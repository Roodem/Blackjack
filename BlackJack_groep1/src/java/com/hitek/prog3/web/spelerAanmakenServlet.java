/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import com.hitek.prog3.db.service.PlayerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MSI
 */
public class spelerAanmakenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //serverside controleren naam niet al gebruikt in database
        String naam = request.getParameter("naam");
        String icoon = request.getParameter("icoon");
        
        
        
        PlayerService ps = new PlayerService();
        ps.persoonToevoegen(icoon, naam);
        
        
      
        
        
        RequestDispatcher view = request.getRequestDispatcher("spelerAanmaken.jsp");
                view.forward(request, response);
        
        
    }
}
