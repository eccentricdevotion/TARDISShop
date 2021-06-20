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
package me.eccentric_nz.tardisshop.database;

import me.eccentric_nz.tardis.utility.TardisStaticLocationGetters;
import me.eccentric_nz.tardisshop.TardisShopPlugin;
import me.eccentric_nz.tardisshop.TardisShopItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetUpdateShop {

    private final TardisShopDatabase service = TardisShopDatabase.getInstance();
    private final Connection connection = service.getConnection();
    private final TardisShopPlugin plugin;

    private List<TardisShopItem> shopItems;

    public ResultSetUpdateShop(TardisShopPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean getAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        final String query = "SELECT * FROM items";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.isBeforeFirst()) {
                shopItems = new ArrayList<>();
                while (resultSet.next()) {
                    shopItems.add(new TardisShopItem(resultSet.getInt("item_id"), resultSet.getString("item"), TardisStaticLocationGetters.getLocationFromBukkitString(resultSet.getString("location")), resultSet.getDouble("cost")));
                }
                return true;
            }
            return false;
        } catch (SQLException e) {
            plugin.debug("ResultSet error for items table! " + e.getMessage());
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                plugin.debug("Error closing items table! " + e.getMessage());
            }
        }
    }

    public List<TardisShopItem> getShopItems() {
        return shopItems;
    }
}
