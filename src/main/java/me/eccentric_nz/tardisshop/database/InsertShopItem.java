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

import me.eccentric_nz.tardisshop.TardisShopPlugin;
import me.eccentric_nz.tardisshop.TardisShopItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertShopItem {

    private final TardisShopPlugin plugin;
    private final TardisShopDatabase service = TardisShopDatabase.getInstance();
    private final Connection connection = service.getConnection();

    /**
     * Inserts data into an SQLite database table. This method builds a prepared SQL statement from the parameters
     * supplied and then executes the insert.
     *
     * @param plugin an instance of the main plugin class
     */
    public InsertShopItem(TardisShopPlugin plugin) {
        this.plugin = plugin;
    }

    public TardisShopItem addNamedItem(String item, double cost) {
        PreparedStatement preparedStatement = null;
        ResultSet idResultSet = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO items (item, cost) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, item);
            preparedStatement.setDouble(2, cost);
            preparedStatement.executeUpdate();
            idResultSet = preparedStatement.getGeneratedKeys();
            int id = (idResultSet.next()) ? idResultSet.getInt(1) : -1;
            return new TardisShopItem(id, item, null, cost);
        } catch (SQLException e) {
            plugin.debug("Insert error for items! " + e.getMessage());
        } finally {
            try {
                if (idResultSet != null) {
                    idResultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                plugin.debug("Error closing items! " + e.getMessage());
            }
        }
        return null;
    }
}
