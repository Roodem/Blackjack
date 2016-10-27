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
import java.util.List;
import model.Player;

/**
 *
 * @author Stone
 */
public class PlayerDAO {
    
    public static List<Player> getAllPlayers(){
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        
        try{
            String qr = "SELECT * FROM player";
        }catch(SQLException e){
            
            
            
        }
        
        
        return null;
    }
    
}
