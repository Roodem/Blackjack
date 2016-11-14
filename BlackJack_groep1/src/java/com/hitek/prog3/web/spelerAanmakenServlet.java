package com.hitek.prog3.web;

import com.hitek.prog3.db.service.PlayerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Player;

/**
 *
 * @author MSI
 */
public class spelerAanmakenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String naam = request.getParameter("naam");
        String icoon = request.getParameter("icoon");
        //admin checkbox
        String checkAdmin = request.getParameter("adminAccount");
        String b = null;

        PlayerService ps = new PlayerService();
        List<Player> lijstPlayersName = ps.getAllPlayersName();

        Boolean bestaatNiet = false;

        for (Player ps2 : lijstPlayersName) {
            if (naam.equalsIgnoreCase(ps2.getNickname())) {
                bestaatNiet = false;
                break;
            } else {
                ps.persoonToevoegen(icoon, naam);
                bestaatNiet = true;
            }
        }
        if (bestaatNiet == true) {
            b = "Gebruikers is toegevoegd";
        } else {
            b = "Naam is bezet, gelieve een ander speler naam te kiezen";
        }

        if (checkAdmin != null) {
            ps.adminAccount(naam);
        }
        request.setAttribute("b", b);
        RequestDispatcher view = request.getRequestDispatcher("spelerAanmaken.jsp");
        view.forward(request, response);
    }
}
