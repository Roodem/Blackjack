/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.DAO;

import com.hitek.prog3.db.util.DatabaseSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author MSI
 */
public class GameDAO {

    public static void datumEnAantalSpelersWijzigen(String tabel, Date datum, int aantalSpelers) {
        String query = "INSERT INTO " + tabel + " (date, aantalspelers) VALUES ('" + datum + "','" + aantalSpelers + "')";

        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void winstWegschrijven(String tabel, int GamegameID, int balance, String playernickname) {
        String query = "INSERT INTO " + tabel + " (GamegameID, balance, Playernickname) VALUES ('" + GamegameID + "','" + balance + "','" + playernickname + "')";

        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int laatsteGameIdOphalen(String tabel, String foreignKey) {
        String query = "SELECT " + foreignKey + " FROM " + tabel + " ORDER BY " + foreignKey + " DESC LIMIT 1";

        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        Statement stmt = null;
        int id = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                id = rs.getInt(foreignKey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
