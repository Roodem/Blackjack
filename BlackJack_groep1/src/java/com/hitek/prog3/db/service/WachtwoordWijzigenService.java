/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.WachtwoordWijzigenDAO;

/**
 *
 * @author Gebruiker
 */
public class WachtwoordWijzigenService {

    /*
 * method WachtwoordWijzigen - wijzigen van een admin wachtwoord
 * @param email, password   
     */
    public static void WachtwoordWijzigen(String mail, String wachtwoord) {
        WachtwoordWijzigenDAO.WijzigenWachtwoord(mail, wachtwoord);
    }
}
