/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import com.hitek.prog3.db.service.PlayerService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI
 */
public class spelerVerwijderenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String naam = request.getParameter("naam");
        
        PlayerService persoon = new PlayerService();
        persoon.persoonVerwijderen(naam);
        
       
        
        RequestDispatcher view = request.getRequestDispatcher("spelerVerwijderen.jsp");
                view.forward(request, response);
        
    }

}
