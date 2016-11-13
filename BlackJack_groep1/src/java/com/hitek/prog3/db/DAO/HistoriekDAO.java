package com.hitek.prog3.db.DAO;

import com.hitek.prog3.db.util.DatabaseSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MSI
 */
public class HistoriekDAO {
    public static ResultSet getHistoriekBepaaldSpeler(String nicknaam){
        String query =  "select gameId, date, player_game.balance " +
                        "from game, player_game, player " +
                        "where game.gameId = player_game.GamegameId " +
                        "and player_game.Playernickname = player.nickname " +
                        "and player_game.Playernickname = '" + nicknaam + "'";
        
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        Statement stmt = null;
               
        try{
            stmt = con.createStatement();
            rs=stmt.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public static ResultSet getOverallHistoriek()
    {
        String query = "SELECT GamegameID, Playernickname, balance from player_game ORDER BY GamegameID DESC";
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        Statement stmt = null;
               
        try{
            stmt = con.createStatement();
            rs=stmt.executeQuery(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
