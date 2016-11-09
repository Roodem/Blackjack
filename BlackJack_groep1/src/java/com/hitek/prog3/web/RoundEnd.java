/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;
import model.Hand;
import model.Player;

/**
 *
 * @author Stone
 */
public class RoundEnd extends HttpServlet {

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
        
        Game currentGame = (Game) request.getSession().getAttribute("game");
        ArrayList<Player> currentPlayers = currentGame.getPlayers();

        String newround = request.getParameter("newround");
        String quit = request.getParameter("quit");

        //ronde afsluiten en naar indexx
        if (quit != null) {

            
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                
                response.sendRedirect("index.jsp");
            }
            
            //balans updaten spelers
            //registratie game

        }

        if (newround != null) {
            //loggen en balance update spelers
            //zelfde spelers inladen
            
           
          //controle of er spelers zijn zonder credits
            ArrayList<Player> playersNoCredits = new ArrayList<>();
            boolean nocredits = false;
            for (Player player : currentPlayers) {
                if (player.getBalance() < 1) {
                    playersNoCredits.add(player);
                    nocredits = true;
                   
                }
            }

            //lege handen
            

            if (nocredits) {
              currentPlayers.removeAll(playersNoCredits);
              request.setAttribute("playernocredits", playersNoCredits);

            }
            
            //alle spelers hebben geen credits meer
            if(currentPlayers.isEmpty()){
                
                 HttpSession session = request.getSession(false);
                 if (session != null) {
                session.invalidate();
                
                response.sendRedirect("index.jsp");
            }
                
            }
            
            for (Player player : currentPlayers) {
                player.setHand(new Hand());

            }

            //new game      
            Game newGame = new Game(currentPlayers);

            //request.getSession(false).invalidate();                    
            request.getSession(true).setAttribute("game", newGame);

            RequestDispatcher dispatcher = request.getRequestDispatcher("gamestart.jsp");
            dispatcher.forward(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
