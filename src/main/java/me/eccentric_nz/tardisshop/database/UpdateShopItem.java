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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UpdateShopItem {

    private final TardisShopPlugin plugin;
    private final TardisShopDatabase service = TardisShopDatabase.getInstance();
    private final Connection connection = service.getConnection();

    public UpdateShopItem(TardisShopPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Updates data in the items table. This method builds an SQL query string from the parameters supplied and then
     * executes the update.
     *
     * @param data  a HashMap<String, Object> of table fields and values update.
     * @param where a HashMap<String, Object> of table fields and values to select the records to update.
     */
    public void alterRecord(HashMap<String, Object> data, HashMap<String, Object> where) {
        PreparedStatement preparedStatement = null;
        String updates;
        String wheres;
        StringBuilder stringBuilderUpdates = new StringBuilder();
        StringBuilder stringBuilderWheres = new StringBuilder();
        data.forEach((key, value) -> stringBuilderUpdates.append(key).append(" = ?,"));
        where.forEach((key, value) -> {
            stringBuilderWheres.append(key).append(" = ");
            if (value instanceof String || value instanceof UUID) {
                stringBuilderWheres.append("'").append(value).append("' AND ");
            } else {
                stringBuilderWheres.append(value).append(" AND ");
            }
        });
        where.clear();
        updates = stringBuilderUpdates.substring(0, stringBuilderUpdates.length() - 1);
        wheres = stringBuilderWheres.substring(0, stringBuilderWheres.length() - 5);
        String query = "UPDATE items SET " + updates + " WHERE " + wheres;
        try {
            preparedStatement = connection.prepareStatement(query);
            int s = 1;
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                if (entry.getValue() instanceof String || entry.getValue() instanceof UUID) {
                    preparedStatement.setString(s, entry.getValue().toString());
                } else if (entry.getValue() instanceof Double) {
                    preparedStatement.setDouble(s, (Double) entry.getValue());
                }
                s++;
            }
            data.clear();
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            plugin.debug("Update error for items table! " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                plugin.debug("Error closing items table! " + e.getMessage());
            }
        }
    }

    public void addLocation(String location, int id) {
        PreparedStatement preparedStatement = null;
        final String query = "UPDATE items SET location = ? WHERE item_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            plugin.debug("Update error for items table! " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                plugin.debug("Error closing items table! " + e.getMessage());
            }
        }
    }

    public void updateCost(double cost, int id) {
        PreparedStatement preparedStatement = null;
        final String query = "UPDATE items SET cost = ? WHERE item_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, cost);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            plugin.debug("Update error for items table! " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                plugin.debug("Error closing items table! " + e.getMessage());
            }
        }
    }
}
