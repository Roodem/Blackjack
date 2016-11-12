package com.hitek.prog3.db.conversie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class HistoriekConversie {
     public static List<String> historiekLijst(ResultSet rs){
        
        List<String> lijst = new ArrayList();
        
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        try{
            while (rs.next()) {
                
                
                String id2 =  Integer.toString(rs.getInt("gameId"));
                String id =  Integer.toString(rs.getInt("gameId"));
                String date = df.format(rs.getDate("date"));
                String balance = Integer.toString(rs.getInt("balance"));
                
                
                lijst.add(id2);
                lijst.add(id);
                lijst.add(date);
                lijst.add(balance);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lijst;
    }
}
