/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.CreditsWijzigenDAO;
import com.hitek.prog3.db.DAO.PlayerAanmakenDAO;
import com.hitek.prog3.db.DAO.PlayerDAO;
import com.hitek.prog3.db.DAO.PlayerVerwijderenDAO;
import com.hitek.prog3.db.conversie.PlayerConversie;
import com.hitek.prog3.db.conversie.PlayerNaamConversie;
import java.util.ArrayList;
import java.util.List;
import model.Player;

/**
 *
 * @author Stone
 */
public class PlayerService {
    
    public ArrayList<Player> getAllPlayers(){
        return PlayerConversie.rsToPlayerList(PlayerDAO.getAllPlayers());
    }
    
    public List<Player> getAllPlayersName(){
        return PlayerNaamConversie.rsToPlayerList(PlayerDAO.getAllPlayers());
    }
    
    public void persoonToevoegen(String icoonid, String nickname){
        PlayerAanmakenDAO.persoonWegschrijven("player", icoonid, nickname, 500);
    }
   
    public void persoonVerwijderen(String nickname){
        PlayerVerwijderenDAO.persoonVerwijderen("player", nickname);
    }
    
    public void persoonCreditsWijzigen(int balance,String nickname){
        CreditsWijzigenDAO.CreditsWijzigen("player", balance, nickname);
    }
    
    
}
