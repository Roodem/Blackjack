<%-- 
    Document   : GraphicsTest
    Created on : 31-okt-2016, 12:30:59
    Author     : Stone
--%>

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
    </head>
    <style type="text/css">
        img {
            width: 20%;
            height: auto;
        }
        
        
        
        
    </style>
    <body>
      
        <h3>Alle spelers uit db halen / vervolgens hun naam en icoon weergeven</h3>
        
        <% //speler ophalen en hun icoon weergeven
            PlayerService ps = new PlayerService();
            List<Player> currentPlayers = ps.getAllPlayers();
            out.write("<p>playercount: "+ currentPlayers.size() + "</p>");
            
    
                 for (Player player : currentPlayers) {
                     out.write("<img src='"+ player.getIcon().getUrl() + "' alt='"+ player.getIcon().getNaam()+"'>"+ player.getNickname()+"</img>");
            
        }
            
        
        %>
       
    </body>
</html>
