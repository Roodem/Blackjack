package com.hitek.prog3.web;

import com.hitek.prog3.db.service.GameService;
import com.hitek.prog3.db.service.PlayerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;
import model.Hand;
import model.Player;

/**
 *
 * @author Stone
 */
public class RoundEnd extends HttpServlet {

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

        Game currentGame = (Game) request.getSession().getAttribute("game");

        ArrayList<Player> currentPlayers = currentGame.getPlayers();

        String newround = request.getParameter("newround");
        String quit = request.getParameter("quit");
        PlayerService credit = new PlayerService();
        GameService game = new GameService();
        //ronde afsluiten en naar indexx
        if (quit != null) {
            //update balance van alle spelers
            for (Player player : currentPlayers) {
                int balance = player.getBalance();
                String name = player.getNickname();
                int gameid = game.gameIdOphalen();
                credit.persoonCreditsWijzigen(balance, name);

                game.winstWegschrijven(gameid, balance, name);
            }

            int aantal = currentGame.getPlayers().size();
            Date datum = currentGame.getDate();
            GameService game2 = new GameService();
            game2.gameToevoegen(datum, aantal);

            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();

                response.sendRedirect("index.jsp");
                return;
            }
        }

        if (newround != null) {
            //update balance van alle spelers
            for (Player player : currentPlayers) {
                int balance = player.getBalance();
                String name = player.getNickname();

                int gameid = game.gameIdOphalen();

                credit.persoonCreditsWijzigen(balance, name);
                game.winstWegschrijven(gameid, balance, name);
            }

            int aantal = currentGame.getPlayers().size();
            Date datum = currentGame.getDate();
            GameService game2 = new GameService();
            game2.gameToevoegen(datum, aantal);

            //controle of er spelers zijn zonder credits
            ArrayList<Player> playersNoCredits = new ArrayList<>();
            boolean nocredits = false;
            for (Player player : currentPlayers) {
                if (player.getBalance() < 1) {
                    playersNoCredits.add(player);
                    nocredits = true;

                }
            }

            if (nocredits) {
                currentPlayers.removeAll(playersNoCredits);
                request.setAttribute("playernocredits", playersNoCredits);

            }

            //alle spelers hebben geen credits meer
            if (currentPlayers.isEmpty()) {
                request.setAttribute("noplayernocredits", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        }

        for (Player player : currentPlayers) {
            player.setHand(new Hand());

        }

        //new game      
        Game newGame = new Game(currentPlayers);

        //request.getSession(false).invalidate();                    
        request.getSession(true).setAttribute("game", newGame);

        RequestDispatcher dispatcher = request.getRequestDispatcher("gamestart.jsp");
        dispatcher.forward(request, response);

    }

}
