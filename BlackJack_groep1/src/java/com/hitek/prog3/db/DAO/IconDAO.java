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
import java.sql.Statement;
import java.util.List;
import model.Icon;
import model.Player;

/**
 *
 * @author Stone
 */
public class IconDAO {
    
     public static Icon getIconByName(String icoonnaam){
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        ResultSet rs = null;
        Icon icon = new Icon();
               
        try{
            String qr = "SELECT * FROM icoon WHERE icoonnaam = '"+ icoonnaam +"' ";
            PreparedStatement stmt = con.prepareStatement(qr);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                icon.setNaam(rs.getString("icoonnaam"));
                icon.setUrl(rs.getString("icoonurl"));
            }
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        return icon;
    }
     
     public static ResultSet getAllIcons(){
        String query = "SELECT * FROM icoon";
        
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
