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
        <style type="text/css">
            #container{
                border: black 1px dotted; width: 1200px; height:800px; margin-left: auto; margin-right: auto;
            }
            #dealer{
                height: auto;
                width: 30%;
                margin: auto;
                top: 0;

            }
            #dealer img{
                height: 120px;
                width: auto;
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
    </head>

    <body>
        <c:set value="${sessionScope.game}" var="game"/>
        <h4>${game}</h4>
        <div id="container">
            <div id="dealer">

                <img src="${game.getDealer().getIcon().getUrl()}" alt="dealer"/>
            </div>
<form name="placebet" action="GameCardRound" method="POST">
            <c:forEach items="${game.getPlayers()}" var="player" varStatus="count">
                <div id="player">
                    <img src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                    <h4>${player.getNickname()}</h4>
                    <p>balance: ${player.getBalance()}</p>

                    
                    <input type="number"  value="1" min="1" max="${player.getBalance()}"  name="bet"/><br>

                       
                </div>
            </c:forEach>
                        

             
                            <input type="submit" name="dealcards" value="Deal Cards"/>
                        </form>
        </div>
    </body>
</html>
