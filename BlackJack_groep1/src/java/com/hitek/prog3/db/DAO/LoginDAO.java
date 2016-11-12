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

/**
 *
 * @author Gebruiker
 */
public class LoginDAO {

    public static int action(String email, String password) {
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        int count = 0;
        try {
            String query = "SELECT email, password FROM admin WHERE ( email = '" + email + "' and password = '" + password + "')";

            Statement stmt = con.createStatement();
        ResultSet    rs = stmt.executeQuery(query);
            
            while (rs.next()) {

                   count = + 1; 
            }
        } catch (SQLException ex) {

        }
        return count;
    }
}
