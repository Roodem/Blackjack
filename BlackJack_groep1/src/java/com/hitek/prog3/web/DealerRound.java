/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Game;
import model.HandStatus;
import model.Player;

/**
 *
 * @author Stone
 */
public class DealerRound extends HttpServlet {

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
        boolean playeractionscomplete = true;
        Game game = (Game) request.getSession().getAttribute("game");
        for (Player player : game.getPlayers()) {
            if (player.getHand().getStatus() == HandStatus.OTHER) {
                playeractionscomplete = false;
            }

        }
        
        if(playeractionscomplete){
                while(game.getDealer().getHand().getStatus() == HandStatus.OTHER){
                        game.DealerHit(game.getDealer());
                }
            
                 try (PrintWriter out = response.getWriter()) {
                 out.println("<p>"+ game.getDealer().getHand().calculateValueHand() +"</p>");
                 
                     out.println("<p>"+ game.getDealer().getHand().getAmountOfcards() +"</p>");
                     out.println("<p>"+ game.getDealer().getHand().getStatus() +"</p>");
                 }
                
            }
        
        
        else{
            
            response.sendRedirect("gameplayerround.jsp");
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
