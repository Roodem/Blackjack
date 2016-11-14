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
import model.Icon;

/**
 *
 * @author MSI
 */
public class IconConversie {

    public static List<Icon> convertResultsetToList(ResultSet rs) {

        List<Icon> icoonlijst = new ArrayList();

        try {
            while (rs.next()) {
                Icon icon = new Icon();
                icon.setNaam(rs.getString("icoonnaam"));
                icon.setUrl(rs.getString("icoonurl"));
                icoonlijst.add(icon);
            }
        } catch (SQLException ex) {

        }
        return icoonlijst;
    }

}
