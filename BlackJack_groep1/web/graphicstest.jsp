<%-- 
    Document   : GraphicsTest
    Created on : 31-okt-2016, 12:30:59
    Author     : Stone
--%>

<%@page import="model.Suit"%>
<%@page import="model.Rank"%>

<%@page import="model.Hand"%>
<%@page import="model.Card"%>
<%@page import="model.Game"%>
<%@page import="model.Deck"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Player"%>
<%@page import="com.hitek.prog3.db.service.PlayerService"%>
<%@page import="model.Icon"%>
<%@page import="com.hitek.prog3.db.service.IconService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style type="text/css">
        img {
            width: auto;
            height: 150px;
        }
    </style>
    </head>
    
    <body>

        <h3>Alle spelers uit db halen / vervolgens hun naam en icoon weergeven</h3>

        <% //speler ophalen en hun icoon weergeven

            PlayerService ps = new PlayerService();
            ArrayList<Player> currentPlayers = ps.getAllPlayers();

            Game g = new Game(currentPlayers);

            Hand test = new Hand();
            Deck d1 = new Deck();
            test.addCard(d1.drawCardFromDeck());
            test.addCard(d1.drawCardFromDeck());
            test.addCard(d1.drawCardFromDeck());

            out.write("<p>" + test.getAmountOfcards() + "</p>");

            for (Card next : test.getCards()) {
               
                 out.write("<img src='images/cards/" + next.toString() + ".gif' alt='" + next.toString() + "'>" + next.toString() + "</img>");
            }
            test.calculateValueHand();
            test.evaluateHandStatus();
            
            out.write("<p>" + test.calculateValueHand() + "</p>");
            out.write("<p>" + test.getStatus() + "</p>");
            
            

            out.write("<p>playercount: " + g.getPlayers().size() + "</p>");

            for (Player player : g.getPlayers()) {

                out.write("<img src='" + player.getIcon().getUrl() + "' alt='" + player.getIcon().getNaam() + "'>" + player.getNickname() + "</img>");
                out.write("<p>" + player.getBalance() + "</p>");

            }


        %>

    </body>
</html>
