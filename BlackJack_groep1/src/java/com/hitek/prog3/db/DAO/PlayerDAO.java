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
import model.Player;

/**
 *
 * @author Stone
 */
public class PlayerDAO {
    
    public static void inserPlayer(Player p){
        //verder afwerken
    }
    
    public static ResultSet getAllPlayers(){
           String qr = "SELECT * FROM player";
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(qr);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return rs;
    }
}
