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
                background-image: url('images/background/starwarsbg.png');
                background-size: contain;
                border: yellow 5px solid;
                border-radius: 25px;
                width: 1200px; height:800px; margin-left: auto; margin-right: auto;
            }
            #dealer{
                height: auto;
                width: 300px;
                height: 300px;
                border:solid red;
                margin: auto;
                top: 0;

            }
            .dealer_img{
                height: 150px;
                margin:auto;
                width: auto;
            }
            #playerside{
                width: 100%;
                height: 400px;
                border: dotted 1px red;
            }
            #player{
                text-align: center;
                display: inline-block;
                width: 24%;
                box-sizing: border-box;

            }
            .player_icon{
                height: 120px;
                width: auto
            }
            #warning{
                color:red;
                
            }

        </style>
    </head>

    <body>


        <c:if test="${requestScope.playernocredits != null}">
            <div id="warning">
                <p>No more Credits</p>
                <ul>
                    <c:forEach items="${requestScope.playernocredits}" var="player">
                        <li>${player.getNickname()}</li>
                        </c:forEach>   
                </ul>
            </div>
        </c:if>

        <div id="container">
            <div id="dealer">

                <img class="dealer_img" src="${game.getDealer().getIcon().getUrl()}" alt="dealer"/>
            </div>
            <div id="playerside">
                <form name="placebet" action="GameCardRound" method="POST">
                    <c:forEach items="${game.getPlayers()}" var="player" varStatus="count">
                        <div id="player">
                            <img class="player_icon" class="card" src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                            <h4>${player.getNickname()}</h4>
                            <p>balance: ${player.getBalance()}</p>


                            <input type="number"  value="1" min="1" max="${player.getBalance()}"  name="bet"/><br>


                        </div>
                    </c:forEach>
            </div>

            <input type="submit" name="dealcards" value="Deal Cards"/>
        </form>
    </div>
</body>
</html>
