<%-- 
    Document   : dealercardround
    Created on : 4-nov-2016, 21:53:29
    Author     : Stone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blackjack Star Wars</title>
        <style type="text/css">
            body{
                 font-family: 'Share Tech Mono', monospace;
                 color: #ffd700;
                 background-color: black;
            }
            #container{
               background-image: url('images/background/starwarsbg.png');
                background-size: 1420px;
                border: silver 5px solid;
                border-radius: 25px;
                width: 1200px; height:800px; margin-left: auto; margin-right: auto;
                margin-top: 50px;
                background-repeat: no-repeat;
            }
            #dealer{
                height: auto;
                width: 300px;
                height: 300px;
                margin-left: 525px;
                top: 0;
            }
            #dealerhand{
                 margin: 0 auto;
            }
            .dealer_img{
                height: 120px;
                width: auto;
                 margin: 0 auto;
            }
            
            #playerside{
                width: 100%;
                height: 400px;
                border: dotted 1px red;
            }
            #player{
                text-align: center;
                display: inline-block;
                margin :auto;
            }
            #playerhand{
                 margin-left: auto;
                margin-right: auto;
            }
            .player_icon{
                height: 120px;
                width: auto
            }
            .card{
                border-radius: 10px;
                height: 120px;
                margin-left: -15%;

            }
            #debug{
                color:red;
                border: dotted 1px;

            }

        </style>
    </head>

    <body>
        <div id="container">
            <div id="dealer">

                <img class="dealer_img" src="${sessionScope.game.getDealer().getIcon().getUrl()}" alt="dealer"/>
                <div id="dealercards">
                    <c:forEach items="${sessionScope.game.getDealer().getHand().getCards()}" var="card">

                        <img class="card" src="images/cards/${card}.gif" alt="${card}"/>



                    </c:forEach>
                    <p>${sessionScope.game.getDealer().getHand().calculateValueHand()}</p> 
                    <p>${sessionScope.game.getDealer().getHand().evaluateHandStatus()}</p> 

                </div>
            </div>

            <c:forEach items="${sessionScope.game.getPlayers()}" var="player" varStatus="count">

                <div id="player">
                    <div id ="playerhand">
                        <c:forEach items="${player.getHand().getCards()}" var="card">
                            <img class="card" src="images/cards/${card}.gif" alt="${card}"/>
                        </c:forEach>
                        <p>${player.getHand().calculateValueHand()}</p>
                        <p>${player.getHand().evaluateHandStatus()}</p>
                        <p>${player.getStatus()}</p>


                    </div>
                    <img  class="player_icon" src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                    <h4>${player.getNickname()}</h4>
                    <p>bet: ${player.getHand().getBet()}</p>

                    <p>balance:${player.getBalance()} </p>



                </div>
            </c:forEach>


            <form method="post" action="RoundEnd">
                <input type="submit" name="newround" value="New Round"/>
                <input type="submit" name="quit" value="Quit Game"/>
            </form>

        </div>

    </body>
</html>
