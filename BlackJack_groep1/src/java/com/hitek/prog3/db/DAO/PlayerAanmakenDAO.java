/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.DAO;

import com.hitek.prog3.db.util.DatabaseSingleton;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MSI
 */
public class PlayerAanmakenDAO {
    
    public static void persoonWegschrijven(String tabel, String icoonid, String nickname, int balance){
        String query = "INSERT INTO " + tabel + " (icoonid, nickname, balance) VALUES ('" + icoonid + "','" + nickname + "','" + balance + "')";
        

        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
