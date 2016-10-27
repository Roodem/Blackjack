/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.util;

/**
 *
 * @author Stone
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Stone
 */
public class DatabaseSingleton {

    public static DatabaseSingleton ref;
    private Connection connection;

    private DatabaseSingleton() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseSingleton getDatabaseSingleton() {
        if (ref == null) {
            ref = new DatabaseSingleton();
        }
        return ref;
    }

    public Connection getConnection(boolean autoCommit) {

        try {

            connection = DriverManager.getConnection(DataBaseProperties.HOSTNAME, DataBaseProperties.USERNAME, DataBaseProperties.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
