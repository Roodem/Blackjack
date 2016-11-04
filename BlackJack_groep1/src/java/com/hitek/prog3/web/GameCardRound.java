
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
import java.util.List;
import javax.servlet.RequestDispatcher;
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
         
          //bets aanvaarden spelers
           String[] test = request.getParameterValues("bet");
           int[] bets = Arrays.stream(test).mapToInt(Integer::parseInt).toArray();
          
           
           int i = 0;
           for (Player player : game.getPlayers()) {
               player.getHand().setBet(bets[i]);
               i++;
              
            
        }
           
          game.CardDistribution();
          
          
           RequestDispatcher dispatcher = request.getRequestDispatcher("gameplayerround.jsp");
           dispatcher.forward(request, response);
          
    }
    
    

}
