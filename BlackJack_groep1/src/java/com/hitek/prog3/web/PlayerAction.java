/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Game;

/**
 *
 * @author Stone
 */
public class PlayerAction extends HttpServlet {

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

        String action = request.getParameter("action");
        int playernr = Integer.parseInt(request.getParameter("playernr"));

        if (action.equals("STAND")) {

            game.PlayerStand(game.getPlayers().get(playernr));

        }

        if (action.equals("HIT")) {
            game.PlayerHit(game.getPlayers().get(playernr));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("gameplayerround.jsp");
        dispatcher.forward(request, response);

    }

}
