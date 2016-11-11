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
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
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
public class GameInit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //index van spelers op halen uit select forms
        String[] test = request.getParameterValues("spelers");

        // nieuwe lijst geslecteerd spelers
        ArrayList<Player> selectedPlayers = new ArrayList<>();
        ArrayList<Player> allPlayers = (ArrayList<Player>) request.getSession().getAttribute("allplayers");

        for (String next : test) {
            int i = Integer.parseInt(next);
            selectedPlayers.add(allPlayers.get(i));

        }
       
        
        Set<Player> playerSet = new HashSet<>();
        playerSet.addAll(selectedPlayers);
        if (playerSet.size() < selectedPlayers.size()) {
            
        
        request.setAttribute("warning", "Iedereen gelieve een ander profiel te kiezen");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        return;

        }

        Game game = new Game(selectedPlayers);

        request.getSession().setAttribute("game", game);

        RequestDispatcher dispatcher = request.getRequestDispatcher("gamestart.jsp");
        dispatcher.forward(request, response);

    }
}
