package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.HistoriekDAO;
import com.hitek.prog3.db.conversie.HistoriekConversie;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author MSI
 */
public class HistoriekService {

    /*
 * method historiekWeergeven - We geven een historiek terug van 1 bepaald speler
 * @param nicknaam - de gewenste speler   
 * @return een lijst conversie van deze bepaalde speler met al zijn records.
     */
    public List<String> historiekWeergeven(String nicknaam) {
        return HistoriekConversie.historiekLijst(HistoriekDAO.getHistoriekBepaaldSpeler(nicknaam));
    }

    /*
 * method volledigHistoriekWeergeven - Opvragen van het volledige historiek 
 * @return volledig historiek  
     */
    public static ResultSet volledigHistoriekWeergeven() {
        return HistoriekDAO.getOverallHistoriek();
    }
}
