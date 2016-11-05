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
    public int action(String username, String password)
    {
         return LoginDAO.action(username,password);

    }
}
