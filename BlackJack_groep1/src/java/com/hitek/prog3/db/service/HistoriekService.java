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
    public List<String> historiekWeergeven(String nicknaam){
       return HistoriekConversie.historiekLijst(HistoriekDAO.getHistoriekBepaaldSpeler(nicknaam));
    }
    public static ResultSet volledigHistoriekWeergeven()
    {
       return HistoriekDAO.getOverallHistoriek();
    }
}
