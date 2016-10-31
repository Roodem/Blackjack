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

    </style>
    <body>
        <div id="container">
            <div id="dealer">
                <c:set value="${requestScope.game.getDealer()}" var="dealer"/>
                <img src="${dealer.getIcon().getUrl()}" alt="dealer"/>
            </div>
        </div>
    </body>
</html>
