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
public class creditsWijzigenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String naam = request.getParameter("naam");
        int credit = Integer.parseInt(request.getParameter("credit"));

        PlayerService persoon = new PlayerService();
        if (credit == 10) {
            persoon.persoonCreditsWijzigen(credit, naam);
        }
        if (credit == 50) {
            persoon.persoonCreditsWijzigen(credit, naam);
        }
        if (credit == 100) {
            persoon.persoonCreditsWijzigen(credit, naam);
        }
        if (credit == 500) {
            persoon.persoonCreditsWijzigen(credit, naam);
        }

        RequestDispatcher view = request.getRequestDispatcher("/creditsWijzigen.jsp");
        view.forward(request, response);

    }
}
