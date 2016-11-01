/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.conversie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI
 */
public class IconConversie {
    
    public static List convertResultsetToList(ResultSet rs){
        
        List lijst = new ArrayList();
        
        try{
            while(rs.next()){
                String naam =null;
                naam = rs.getString("icoonnaam");
                lijst.add(naam);
            }
        }catch(SQLException ex){
            
        }
        return lijst;
    }
    
}
