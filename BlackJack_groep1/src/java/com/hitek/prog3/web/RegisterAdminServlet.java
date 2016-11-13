/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import com.hitek.prog3.db.service.LoginService;
import com.hitek.prog3.db.service.RegisterAdminService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;

/**
 *
 * @author Gebruiker
 */
public class RegisterAdminServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        String confirmPassword = request.getParameter("confirmPassword");
        Admin admin = new Admin();
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        LoginService login = new LoginService();
        int check = login.getAllAdmin();
       
        if (check == 0) {

            if (email != null && name != null) {

                if (Admin.validate(email)) {
                    if (password != null) {
                        if (password.equals(confirmPassword)) {
                             RegisterAdminService RA = new RegisterAdminService();
                             RA.registerAdmin(name, email, password);
                            RequestDispatcher view = request.getRequestDispatcher("registersucces.html");
                            view.forward(request, response);
                        } else {
                            String errorConfirmed = "Wachtwoord onjuist bevestigd";
                            request.getServletContext().setAttribute("errorConfirmed", errorConfirmed);
                            RequestDispatcher view = request.getRequestDispatcher("registerAdmin.jsp");
                            view.forward(request, response);
                        }

                    }

                } else {
                    String errormessage = "Ongeldig emailadres. Voorbeeld: Example@example.com";
                    request.getServletContext().setAttribute("errormessage", errormessage);
                    RequestDispatcher view = request.getRequestDispatcher("registerAdmin.jsp");
                    view.forward(request, response);
                }
            }

        }
        else if(check >= 1)
        {
            String errorMaxAdmin = "Er mag slechts 1 hoofdgebruikersaccount per applicatie gemaakt worden.";
            request.getServletContext().setAttribute("errorMaxAdmin",errorMaxAdmin);
            RequestDispatcher view = request.getRequestDispatcher("registerAdmin.jsp");
            view.forward(request,response);
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
