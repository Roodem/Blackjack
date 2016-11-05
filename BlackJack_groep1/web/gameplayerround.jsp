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
            #debug{
                color:red;
                border: dotted 1px;

            }

        </style>
    </head>

    <body>

        
        <div id="container">
            <div id="dealer">

                <img src="${sessionScope.game.getDealer().getIcon().getUrl()}" alt="dealer"/>
                <div id="dealercards">
                    <c:forEach items="${sessionScope.game.getDealer().getHand().getCards()}" var="card">
                        <c:if test="${card.getVisible()}">
                            <img src="images/cards/${card}.gif" alt="${card}"/>
                        </c:if>
                        <c:if test="${!card.getVisible()}">
                            <img src="images/cards/BACKSIDE.gif" alt="hiddencard"/>
                        </c:if>


                    </c:forEach>
                </div>
            </div>

            <c:forEach items="${sessionScope.game.getPlayers()}" var="player" varStatus="count">

                <div id="player">
                    <div id ="playerhand">
                        <c:forEach items="${player.getHand().getCards()}" var="card">
                            <img src="images/cards/${card}.gif" alt="${card}"/>
                        </c:forEach>
                        <p>${player.getHand().calculateValueHand()}</p>
                        <p>${player.getHand().evaluateHandStatus()}</p>
                        <p>${player.getHand().getStatus()}</p>


                    </div>
                    <img src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                    <h4>${player.getNickname()}</h4>
                    <p>bet: ${player.getHand().getBet()}</p>
                    <!--                    speler kan zolang hij niet BURNED/STAND/BJ heeft kaarten bijvragen-->
                    <form name="playeraction" method="POST" action="PlayerAction ">
                        <c:if test="${player.getHand().getStatus() == 'OTHER'}">
                            <c:set value="${true}"  var="stillAction" /> 
                            <input type="hidden" value="${count.index.toString()}" name="playernr"/>
                            <input type="submit" value ="HIT" name="action"/>
                            <input type="submit" value ="STAND"  name="action"/>
                        </c:if>
                    </form>


                </div>
            </c:forEach>
                
                <c:if test="${!stillAction}" > 
                <form method="POST" action="DealerRound">       
                    <input type="submit" name="dealerround" value="reveal dealer"/>
                </form>
                </c:if>
        </div>
      
    </body>
</html>
