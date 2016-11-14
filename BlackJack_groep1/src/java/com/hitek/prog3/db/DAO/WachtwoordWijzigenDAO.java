/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.DAO;

import com.hitek.prog3.db.util.DatabaseSingleton;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gebruiker
 */
public class WachtwoordWijzigenDAO {

    /*
 * method WijzigenWachtwoord - Het wijzigen van een admin wachtwoord
 * @param email - we geven een email adres mee om een admin record te herkennen. 
 * @param nieuw - het nieuwe wachtwoord die we vervangen met het oude.   
     */
    public static void WijzigenWachtwoord(String mail, String nieuw) {
        String query = "UPDATE admin SET password=('" + nieuw + "') WHERE email=('" + mail + "') ";

        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);

        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
