
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Game;
import model.Player;

/**
 *
 * @author Stone
 */
public class GameCardRound extends HttpServlet {

   
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
          Game game = (Game) request.getSession().getAttribute("game");
          ArrayList<Player> currentplayers = game.getPlayers();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GameCardRound</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>gameobject:  " + game + "</h1>");
            out.println("<h1>amount of players:  " + game.getPlayers().size() +"</h1>");
            
            for (int i = 0; i < game.getPlayers().size();i ++) {
                out.println("<h4>player name:  " + currentplayers.get(i).getNickname() + "</h4>");
                out.println("<h4>player balance:  " + currentplayers.get(i) + "</h4>");
                 out.println("<h4>amount of cards hand:  " + currentplayers.get(i).getHand().getCards().size() + "</h4>");
                
            }
               
            
             out.println("<h1>gameobject:  " + game + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
   

}
