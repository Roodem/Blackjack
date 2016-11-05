/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.hitek.prog3.db.util.DatabaseSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Gebruiker
 */
public class Login {
    Connection con;
    Statement st;
    ResultSet rs;
     
    public Login()
    {
        connect();
        frame();
    }
    
    public void connect()
    {
        try
        {
        con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        st = con.createStatement();
        }
        catch(Exception ex)
        {
            
        }
    }
    public void frame()
    {
        
    }
}
