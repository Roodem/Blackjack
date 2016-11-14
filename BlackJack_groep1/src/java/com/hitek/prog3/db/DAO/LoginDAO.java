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

    /*
 * method action - opvragen van een record met de opgegeven email en wachtwoord
 * @param email, password   
 * @return count retourneert een integer die we later kunnen gebruiken om te weten of de gegeven parameters overeen komen met wat er in onze database staat. 
     */
    public static int action(String email, String password) {
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        int count = 0;
        try {
            String query = "SELECT email, password FROM admin WHERE ( email = '" + email + "' and password = '" + password + "')";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                count = +1;
            }
        } catch (SQLException ex) {

        }
        return count;
    }

    /*
 * method getAllAdmin - opvragen hoeveel records er van admin zijn
 * @return count - waarbij we verwachten dat dit 0 of 1 is.
     */
    public static int getAllAdmin() {
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
        int count = 0;
        try {
            String query = "SELECT * FROM admin";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                count = +1;
            }
        } catch (SQLException ex) {

        }
        return count;
    }
}
