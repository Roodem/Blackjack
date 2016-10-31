/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Player;

/**
 *
 * @author Stone
 */
public class GameInit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    //index van spelers op halen uit select forms
       String[] test = request.getParameterValues("spelers");
       
       
      // nieuwe lijst geslecteerd spelers
      ArrayList<Player> selectedPlayers = new  ArrayList<>();
       ArrayList<Player> allPlayers = (ArrayList<Player>) request.getSession().getAttribute("allplayers");
      
        for (String next : test) {
            int i = Integer.parseInt(next);
            selectedPlayers.add(allPlayers.get(i));
           
            
        }
    response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> gekozen spelers" + new ArrayList(Arrays.asList(selectedPlayers)).toString() + "</h1>");
            out.println("<h1>" + new ArrayList((Collection) request.getSession().getAttribute("allplayers")).toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    
    
    
    }
}
