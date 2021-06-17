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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TardisShopDatabase {

    private static final TardisShopDatabase INSTANCE = new TardisShopDatabase();
    public Connection connection = null;
    public Statement statement = null;

    public static synchronized TardisShopDatabase getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(String path) throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
    }

    public void createTables() {
        try {
            statement = connection.createStatement();
            // Table structure for table 'items'
            final String queryItems = "CREATE TABLE IF NOT EXISTS items (item_id INTEGER PRIMARY KEY NOT NULL, item TEXT DEFAULT '', location TEXT DEFAULT '', cost REAL DEFAULT 0)";
            statement.executeUpdate(queryItems);
        } catch (SQLException e) {
            System.err.println("[TARDISShop] Error creating tables: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("[TARDISShop] Error closing SQL statement: " + e.getMessage());
            }
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone is not allowed.");
    }
}
