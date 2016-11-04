package com.hitek.prog3.db.conversie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Player;

/**
 *
 * @author MSI
 */
public class PlayerNaamConversie {
    
    public static List<Player> rsToPlayerList(ResultSet rs){
        
        List playerlist = new ArrayList();
        try{
            while (rs.next()) {
                Player p = new Player();
                p.setNickname(rs.getString("nickname"));
                playerlist.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return playerlist;
    }
    
}
