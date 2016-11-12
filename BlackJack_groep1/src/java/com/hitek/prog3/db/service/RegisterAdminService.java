/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.RegisterAdminDAO;

/**
 *
 * @author Gebruiker
 */
public class RegisterAdminService {
    public void registerAdmin(String name, String email, String password)
    {
        RegisterAdminDAO.insertAdmin(name, email, password);
    }
}
