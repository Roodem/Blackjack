/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.GameDAO;
import java.util.Date;

/**
 *
 * @author Stone
 */
public class GameService {
    public void gameToevoegen(Date datum, int aantalSpelers){
        GameDAO.datumEnAantalSpelersWijzigen("game", datum, aantalSpelers);
    }
    
    public void winstWegschrijven(int GamegameID, int balance, String playernickname){
        GameDAO.winstWegschrijven("player_game", GamegameID, balance, playernickname);
    }
    
}
