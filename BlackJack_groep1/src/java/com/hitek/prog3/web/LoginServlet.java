/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hitek.prog3.web;

import com.hitek.prog3.db.service.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * @author Gebruiker
 */
public class LoginServlet extends HttpServlet {

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
        //email van de gebruiker 
        String email = request.getParameter("username");
        //wachtwoord van de gebruiker
        String password = request.getParameter("password");

        //instantie van LoginService 
        LoginService login = new LoginService();
        //Controleer of de gegevens overeen komen met wat hier wordt ingegeven 
        int check = login.action(email, password);

        //vraag de huidige sessie op
        HttpSession session = request.getSession();
        
        //valideer email met regex
        if (Admin.validate(email)) {
            if (check == 0)//er zijn geen records gevonden
            {
                //keer terug naar index omdat we foutieve records ingeven.
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);

            } else if (check == 1)//er is een admin record gevonden
            {
                //sla email op in email attribuut die alsook gebruiken als check om te controleren of we in beheer toegang krijgen bij bepaalde pagina's.
                session.setAttribute("email", email);
                //stuur mij door naar beheer pagina 
                RequestDispatcher view = request.getRequestDispatcher("beheer.jsp");
                view.forward(request, response);
            }
        } else {
            //fout bericht
            String errormessage = "Controleer uw emailadres opnieuw. bv: example@example.com";
            //fout bericht attribuut
            session.setAttribute("errormessage", errormessage);
            //stuur mij terug naar login
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request, response);
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
