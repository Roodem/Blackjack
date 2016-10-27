/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.PlayerDAO;
import java.util.List;
import model.Player;

/**
 *
 * @author Stone
 */
public class PlayerService {
    
    public List<Player> getAllPlayers(){
        return PlayerDAO.getAllPlayers();
        
    }
    
}
