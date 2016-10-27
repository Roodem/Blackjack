/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.DAO;

import com.hitek.prog3.db.util.DatabaseSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Icon;
import model.Player;

/**
 *
 * @author Stone
 */
public class PlayerDAO {
    
    public static List<Player> getAllPlayers(){
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        List<Player> players = null;
               
        try{
            String qr = "SELECT (nickname, balance, icoonid) * FROM player";
            PreparedStatement stmt = con.prepareStatement(qr);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Player p = new Player();
                p.setNickname(rs.getString("nickname"));
                p.setBalance(rs.getInt("balance"));
                p.setIcon(new Icon("icoonnaam", "icoonurl"));
                
                players.add(p);
                
                
            }
        }catch(SQLException e){
            
            e.printStackTrace();
            
            
            
            
        }
        
        
        return null;
    }
    
}
