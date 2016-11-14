/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.LoginDAO;

/**
 *
 * @author Gebruiker
 */
public class LoginService {
 /*
 * method action - het uitvoeren van de login action in LoginDAO
 * @param username - het email adres
 * @param password - het wachtwoord   
 * @return een integer die aangeeft of de accoutn gegevens overeen komen met wat er is ingegeven.
 */
  
    public int action(String username, String password)
    {
         return LoginDAO.action(username,password);

    }
/*
 * method getAllAdmin - opvragen van een record met de opgegeven email en wachtwoord
 * @param email, password   
 * @return een integer die 0 of 1 zal weergeven om te controleren of er al een admin bestaat.   
 */
  
    public int getAllAdmin() {
        return LoginDAO.getAllAdmin();
    }
}
