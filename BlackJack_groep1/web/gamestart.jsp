<%-- 
    Document   : Game
    Created on : Oct 24, 2016, 9:58:08 AM
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style type="text/css">
        #container{
            border: black 1px dotted; width: 950px; height:600px; margin-left: auto; margin-right: auto;
        }
        #dealer{
            height: auto;
            width: 30%;
            margin: auto;
            top: 0;
            
        }
        #player{
            text-align: center;
            display: inline-block;
            margin :auto;
        }
        #player img{
            height: 120px;
            width: auto
        }

    </style>
    <body>
        <c:set value="${requestScope.game}" var="game"/>
        <div id="container">
            <div id="dealer">

                <img src="${game.getDealer().getIcon().getUrl()}" alt="dealer"/>
            </div>

            <c:forEach items="${game.getPlayers()}" var="player" varStatus="count">
                <div id="player">
                    <img src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                    <h4>${player.getNickname()}</h4>
                    <p>balance: ${player.getBalance()}</p>
                    
                    <form name="frm_player_${count.index.toString()+1}" method="POST">
                        <input type="text" value="bet"/><br>
                        <input type="submit" value="placebet"/>
                    </form>


                </div>
            </c:forEach>
        </div>
    </body>
</html>
