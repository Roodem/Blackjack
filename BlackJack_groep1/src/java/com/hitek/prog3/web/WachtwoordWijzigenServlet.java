/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import com.hitek.prog3.db.service.RegisterAdminService;
import com.hitek.prog3.db.service.WachtwoordWijzigenService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gebruiker
 */
public class WachtwoordWijzigenServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

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
        String email = request.getParameter("email");
        String password = request.getParameter("nieuwWachtwoord");
        String confirmPassword = request.getParameter("confirmPassword");
        if (password != null) {
            if (password.equals(confirmPassword)) {
                WachtwoordWijzigenService.WachtwoordWijzigen(email, password);
                RequestDispatcher view = request.getRequestDispatcher("confirmChange.html");
                view.forward(request, response);
            } else {
                String errorConfirmed = "Wachtwoord onjuist bevestigd";
                request.getServletContext().setAttribute("errorConfirmed", errorConfirmed);
                RequestDispatcher view = request.getRequestDispatcher("wachtwoordWijzigen.jsp");
                view.forward(request, response);
            }

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
