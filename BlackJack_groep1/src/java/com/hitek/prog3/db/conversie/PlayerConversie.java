/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.conversie;

import com.hitek.prog3.db.service.IconService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Icon;
import model.Player;

/**
 *
 * @author Stone
 */
public class PlayerConversie {
    
    public static ArrayList<Player> rsToPlayerList(ResultSet rs){
        IconService is = new IconService();
        ArrayList playerlist = new ArrayList();
        try{
            while (rs.next()) {
                //haal icoon op
              Icon icon =  is.getIconByID(rs.getString("IcoonId"));
              Player p = new Player();
              
              p.setIcon(icon);
              p.setNickname(rs.getString("nickname"));
              p.setBalance(rs.getInt("balance"));
              p.setHand(null);
              
              playerlist.add(p);
              
                
            }
           
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return playerlist;
    }
    
}
