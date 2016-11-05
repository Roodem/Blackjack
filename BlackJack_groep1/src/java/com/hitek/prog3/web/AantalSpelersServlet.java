/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import com.hitek.prog3.db.service.PlayerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Player;

/**
 *
 * @author Stone
 */
public class AantalSpelersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //control op profielen met 0 credits
        // lijst met alle speler objecten ophalen
        PlayerService ps = new PlayerService();
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers = ps.getAllPlayers();

        int aantal = Integer.parseInt(request.getParameter("aantalspelers"));

        if (allPlayers.size() < aantal) {
            aantal = allPlayers.size();
            request.setAttribute("label", "er zijn maar " + aantal + " Spelers geregistreerd");
        }

        ArrayList<Player> playersNoCredits = new ArrayList<>();
        
        //allplayers checken op genoeg credits
        for (ListIterator<Player> iterator = allPlayers.listIterator(); iterator.hasNext();) {
            Player next = iterator.next();
            if (next.getBalance() < 1) {
                playersNoCredits.add(next);
              

            }

        }
        
        for (ListIterator<Player> iterator = playersNoCredits.listIterator(); iterator.hasNext();) {
            Player next = iterator.next();
            if (next.getBalance() < 1) {
                allPlayers.remove(next);
              

            }

        }
      
            request.setAttribute("nocreditplayers", playersNoCredits);
           
        

        request.getSession().setAttribute("allplayers", allPlayers);
        request.setAttribute("aantal", aantal);
        RequestDispatcher view = request.getRequestDispatcher("profielkiezen.jsp");
        view.forward(request, response);

    }

}
