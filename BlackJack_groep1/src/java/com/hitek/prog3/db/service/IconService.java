/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.db.service;

import com.hitek.prog3.db.DAO.IconDAO;
import com.hitek.prog3.db.conversie.IconConversie;
import java.util.List;
import model.Icon;

/**
 *
 * @author Stone
 */
public class IconService {

    public Icon getIconByID(String icoonnaam) {
        return IconDAO.getIconByName(icoonnaam);

    }

    public List<Icon> getAllIcon() {
        return IconConversie.convertResultsetToList(IconDAO.getAllIcons());

    }

}
