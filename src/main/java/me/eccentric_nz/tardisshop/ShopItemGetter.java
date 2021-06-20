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

import me.eccentric_nz.tardis.TardisPlugin;
import me.eccentric_nz.tardis.planets.TardisAngelsApi;
import me.eccentric_nz.tardisweepingangels.TardisWeepingAngelsApi;
import me.eccentric_nz.tardisweepingangels.utils.Monster;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ShopItemGetter {

    public static ItemStack getTWAItem(ShopItem item) {
        if (TardisShopPlugin.isTWAEnabled()) {
            // get TARDISWeepingAngels API
            TardisWeepingAngelsApi weepingAngelsAPI = TardisAngelsApi.getAPI(TardisPlugin.plugin);
            if (item.getMaterial() == Material.BONE) {
                // K9
                return weepingAngelsAPI.getK9();
            } else {
                // Monster head
                String m = item.toString().replace("_HEAD", "");
                Monster monster = Monster.valueOf(m);
                return weepingAngelsAPI.getHead(monster);
            }
        }
        return null;
    }

    public static ItemStack getSeedItem(ShopItem item) {
        String s = item.toString().replace("_SEED", "");
        return TardisShopPlugin.getTardisAPI().getTARDISSeedItem(s);
    }

    public static ItemStack getShapeItem(ShopItem item, Player player) {
        return TardisShopPlugin.getTardisAPI().getTARDISShapeItem(item.getDisplayName(), player);
    }

    public static ItemStack getBlueprintItem(ShopItem item, Player player) {
        return TardisShopPlugin.getTardisAPI().getTARDISBlueprintItem(item.toString(), player);
    }
}
