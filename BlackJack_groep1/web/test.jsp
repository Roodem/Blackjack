<%-- 
    Document   : test
    Created on : 4-nov-2016, 13:40:25
    Author     : Stone
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach items="${sessionScope.game.getPlayers()}" var="player">
            
            <c:forEach items="${player.getHand().getCards()}" var="card">
                <img src="images/cards/${card}.gif"/>
            </c:forEach>
               <p>${player.getHand().evaluateHandStatus()}</p>
               <p>${player.getHand().calculateValueHand()}</p>
        </c:forEach>
    </body>
</html>
