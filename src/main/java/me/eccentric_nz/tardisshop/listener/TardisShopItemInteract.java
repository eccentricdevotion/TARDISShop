/*
 * Copyright (C) 2021 eccentric_nz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package me.eccentric_nz.tardisshop.listener;

import me.eccentric_nz.tardis.utility.TARDISStringUtils;
import me.eccentric_nz.tardisshop.*;
import me.eccentric_nz.tardisshop.database.DeleteShopItem;
import me.eccentric_nz.tardisshop.database.ResultSetShopItem;
import me.eccentric_nz.tardisshop.database.UpdateShopItem;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.UUID;

public class TardisShopItemInteract implements Listener {

    private final TardisShopPlugin plugin;

    public TardisShopItemInteract(TardisShopPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteract(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }
        Block block = event.getClickedBlock();
        if (block != null && block.getType() == plugin.getBlockMaterial()) {
            Location location = block.getLocation();
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Player player = event.getPlayer();
                UUID uuid = player.getUniqueId();
                if (plugin.getSettingItem().containsKey(uuid)) {
                    TardisShopItem item = plugin.getSettingItem().get(uuid);
                    Location drop = location.clone().add(0.5d, 1.05d, 0.5d);
                    new TardisShopItemSpawner(plugin).setItem(drop, item);
                    // update location in database
                    new UpdateShopItem(plugin).addLocation(location.toString(), item.getId());
                    player.sendMessage(plugin.getPluginName() + "Item location added to database!");
                    plugin.getSettingItem().remove(uuid);
                } else if (plugin.getRemovingItem().contains(uuid)) {
                    for (Entity entity : block.getWorld().getNearbyEntities(location, 1.0d, 2.0d, 1.0d)) {
                        if (entity instanceof Item && entity.getPersistentDataContainer().has(plugin.getItemKey(), PersistentDataType.INTEGER) || entity instanceof ArmorStand) {
                            entity.remove();
                        }
                    }
                    // remove database record
                    if (new DeleteShopItem(plugin).removeByLocation(location.toString()) > 0) {
                        player.sendMessage(plugin.getPluginName() + "Item removed from database");
                    } else {
                        player.sendMessage(plugin.getPluginName() + "Item location not found in database!");
                    }
                    plugin.getRemovingItem().remove(uuid);
                } else {
                    // is it a shop block?
                    ResultSetShopItem resultSetShopItem = new ResultSetShopItem(plugin);
                    if (resultSetShopItem.itemFromBlock(location.toString())) {
                        TardisShopItem item = resultSetShopItem.getShopItem();
                        String message;
                        // do they have sufficient credit?
                        if (player.hasPermission("tardis.admin") && plugin.getConfig().getBoolean("tardis_admin_free")) {
                            // give item
                            giveItem(item.getItem(), player);
                            message = "Freebies for admins :)";
                        } else if (plugin.getEconomy().getBalance(player) > item.getCost()) {
                            // give item
                            giveItem(item.getItem(), player);
                            plugin.getEconomy().withdrawPlayer(player, item.getCost());
                            message = "Item purchased :)";
                        } else {
                            // no credit
                            message = "You have insufficient credit available to purchase this item!";
                        }
                        player.sendMessage(plugin.getPluginName() + message);
                    }
                }
            } else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                ResultSetShopItem resultSetShopItem = new ResultSetShopItem(plugin);
                event.setCancelled(resultSetShopItem.itemFromBlock(location.toString()));
            }
        }
    }

    private void giveItem(String item, Player player) {
        try {
            ShopItem recipe = ShopItem.valueOf(TARDISStringUtils.toEnumUppercase(item));
            ItemStack itemStack = switch (recipe.getRecipeType()) {
                case BLUEPRINT -> ShopItemGetter.getBlueprintItem(recipe, player);
                case TWA -> ShopItemGetter.getTWAItem(recipe);
                case SEED -> ShopItemGetter.getSeedItem(recipe);
                default -> ShopItemGetter.getShapeItem(recipe, player);
            };
            if (itemStack != null) {
                HashMap<Integer, ItemStack> res = player.getInventory().addItem(itemStack); // TODO Figure out what this variable is supposed to be, and change its name to be more understandable.
                if (!res.isEmpty()) {
                    for (ItemStack stack : res.values()) {
                        player.getWorld().dropItem(player.getLocation(), stack);
                    }
                }
                player.updateInventory();
            }
        } catch (IllegalArgumentException e) {
            plugin.debug("Could not get ShopItemRecipe from item string. " + e.getMessage());
        }
    }
}
