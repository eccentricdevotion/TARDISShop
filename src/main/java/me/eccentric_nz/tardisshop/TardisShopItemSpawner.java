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
package me.eccentric_nz.tardisshop;

import me.eccentric_nz.TARDIS.utility.TARDISStringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import java.util.Objects;

public class TardisShopItemSpawner {

    private final TardisShopPlugin plugin;

    public TardisShopItemSpawner(TardisShopPlugin plugin) {
        this.plugin = plugin;
    }

    public void setItem(Location location, TardisShopItem what) {
        String toEnum = TARDISStringUtils.toEnumUppercase(what.getItem());
        try {
            ShopItem shopItem = ShopItem.valueOf(toEnum);
            ItemStack itemStack = new ItemStack(shopItem.getMaterial(), 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setCustomModelData(shopItem.getCustomModelData());
            itemMeta.setDisplayName(what.getItem());
            itemMeta.getPersistentDataContainer().set(plugin.getItemKey(), PersistentDataType.INTEGER, 10001);
            itemStack.setItemMeta(itemMeta);
            Item item = location.getWorld().dropItem(location, itemStack);
            item.setVelocity(new Vector(0, 0, 0));
            item.getPersistentDataContainer().set(plugin.getItemKey(), PersistentDataType.INTEGER, 10001);
            item.setCustomName(what.getItem());
            item.setCustomNameVisible(true);
            item.setPickupDelay(Integer.MAX_VALUE);
            item.setInvulnerable(true);
            item.setVelocity(new Vector(0, 0, 0));
            ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(location.clone().add(0, -1.05d, 0), EntityType.ARMOR_STAND);
            armorStand.setSmall(true);
            armorStand.setVisible(false);
            armorStand.setCustomName(ChatColor.RED + "Cost:" + ChatColor.RESET + String.format(" %.2f", what.getCost()));
            armorStand.setCustomNameVisible(true);
            armorStand.setGravity(false);
            armorStand.setInvulnerable(true);
            armorStand.setVelocity(new Vector(0, 0, 0));
        } catch (IllegalArgumentException e) {
            plugin.debug("Illegal shop item [" + toEnum + "] :" + e.getMessage());
        }
    }
}
