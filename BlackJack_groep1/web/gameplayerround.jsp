<%-- 
    Document   : GameActionRound
    Created on : 2-nov-2016, 18:00:57
    Author     : Stone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blackjack Star Wars</title>
        <link href="https://fonts.googleapis.com/css?family=Share+Tech+Mono" rel="stylesheet">
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
                background-size: cover;
            }
            #dealer{
                height: auto;
                width: 300px;
                height: 300px;
                margin-left: 525px;
                top: 0;
            }
            .dealer_img{
                height: 120px;
                margin: 0 auto;
                width: auto;
            }
            #dealerhand{
                margin: 0 auto;

            }
            #playerside{
                width: 100%;
                height: 400px;

            }


            #player{
                text-align: center;
                display: inline-block;
                width: 24%;
                box-sizing: border-box;


            }
            #playerhand{


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
            #controls{
                position: absolute;
                top: 100px;
                left: 100px ;
            }

            #action{
                position: absolute;
                top: 50px;
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
                <div id="dealerhand">
                    <c:forEach items="${sessionScope.game.getDealer().getHand().getCards()}" var="card">
                        <c:if test="${card.getVisible()}">
                            <img class="card" src="images/cards/${card}.gif" alt="${card}"/>
                        </c:if>
                        <c:if test="${!card.getVisible()}">
                            <img class="card" src="images/cards/BACKSIDE.gif" alt="hiddencard"/>
                        </c:if>


                    </c:forEach>
                </div>
            </div>
            <div id="playerside" >  
                <c:forEach items="${sessionScope.game.getPlayers()}" var="player" varStatus="count">

                    <div id="player">
                        <div id ="playerhand">
                            <c:forEach items="${player.getHand().getCards()}" var="card">
                                <img class="card" src="images/cards/${card}.gif" alt="${card}"/>
                            </c:forEach>
                            <p>${player.getHand().calculateValueHand()}</p>
                            <p>${player.getHand().evaluateHandStatus()}</p>



                        </div>
                        <img class="player_icon" src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                        <h4>${player.getNickname()}</h4>
                        <p>bet: ${player.getHand().getBet()}</p>
                        <!--                    speler kan zolang hij niet BURNED/STAND/BJ heeft kaarten bijvragen-->
                        <form id="playeraction" name="playeraction" method="POST" action="PlayerAction ">
                            <c:if test="${player.getHand().getStatus() == 'OTHER'}">
                                <c:set value="${true}"  var="stillAction" /> 
                                <input type="hidden" value="${count.index.toString()}" name="playernr"/>
                                <input type="submit" value ="HIT" name="action"/>
                                <input type="submit" value ="STAND"  name="action"/>
                            </c:if>
                        </form>


                    </div>
                </c:forEach>
            </div>    
            <c:if test="${!stillAction}" > 
                <div id="controls>">
                    <form id="action" method="POST" action="DealerRound">       
                        <input type="submit" name="dealerround" value="reveal dealer"/>
                    </form>
                </div>
            </c:if>
        </div>

    </body>
</html>
