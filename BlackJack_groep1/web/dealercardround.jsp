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

        <h4>${sessionScope.game}</h4>
        <div id="container">
            <div id="dealer">

                <img src="${sessionScope.game.getDealer().getIcon().getUrl()}" alt="dealer"/>
                <div id="dealercards">
                    <c:forEach items="${sessionScope.game.getDealer().getHand().getCards()}" var="card">

                        <img src="images/cards/${card}.gif" alt="${card}"/>



                    </c:forEach>
                    <p>${sessionScope.game.getDealer().getHand().calculateValueHand()}</p> 
                    <p>${sessionScope.game.getDealer().getHand().evaluateHandStatus()}</p> 

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
                        <h3>${player.getStatus()}</h3>


                    </div>
                    <img src="${player.getIcon().getUrl()}" alt="${player.getNickname()}"/>
                    <h4>${player.getNickname()}</h4>
                    <p>bet: ${player.getHand().getBet()}</p>

                    <p>balance:${player.getBalance()} </p>



                </div>
            </c:forEach>

                   
               
               
        </div>
        <!--        <div id="debug">
                    <p>${game}</p>
                    <p>${game.getDealer()}</p>
                    <p>${game.getDeck()}</p>
        
        <c:forEach items="${game.getPlayers()}" var="player">
            <p>${player}</p>
            <p>${player.getHand()}</p>
            <p>handstatus: ${player.getHand().evaluateHandStatus()}</p>
            <p>spelerstatus: ${player.getStatus()}</p>

        </c:forEach>
    </div>
</body>-->
</html>
