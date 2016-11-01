package com.hitek.prog3.db.conversie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Player;

/**
 *
 * @author MSI
 */
public class PlayerNaamConversie {
    
    public static ArrayList<Player> rsToPlayerList(ResultSet rs){
        
        ArrayList playerlist = new ArrayList();
        try{
            while (rs.next()) {
                String naam = null;
                naam= rs.getString("nickname");
                playerlist.add(naam);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return playerlist;
    }
    
}
