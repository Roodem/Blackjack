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
            #dealerhand{
                
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
            #playerhand{
                
                
            }
            .player_icon{
                 height: 120px;
                width: auto
            }
            
            .card{
                border-radius: 10px;
                height: 120px;
                display:inline; 
                
                
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

                <h1>${sessionScope.game}</h1>

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
                        <p>${player.getHand().getStatus()}</p>


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
                    <form id="action" method="POST" action="DealerRound">       
                    <input type="submit" name="dealerround" value="reveal dealer"/>
                </form>
                </c:if>
        </div>
      
    </body>
</html>
