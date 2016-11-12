<%-- 
    Document   : profielkiezen
    Created on : 27-okt-2016, 9:07:11
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
            @font-face{
                font-family: starwars;
                src:url('css/fonts/OptimusPrincepsSemiBold.ttf');
            }
            body{
                color: silver; 
                background-color:black;
                font-family: "starwars";
                    
            }
            #container{
                width:1300px;
                margin-left: auto;
                margin-right: auto;
                margin-top: 100px;
                border: silver 5px solid;
                width: 1200px;
                height:650px;
                margin-left:auto;
                margin-right:auto;
                padding: 20px;
                border-radius: 25px;
                background: url("images/background/joda.jpg");
                background-size: 1300px;
                background-repeat: no-repeat;
            }
            .label{
                color: red;
            }
            select{
                margin-left: 50px;
            }
            input{
                background-color:black;
                font-family: "starwars";
                padding:50px;
                font-size:50px;
                margin-left: 150px;
                margin-top: 100px;
                color:silver;
            }
            input:hover{
                text-decoration: underline;
            }
            h1{
                margin-left:50px;
            }
        </style>

    </head>
    <body>
        <div id="container">
            <h1>Kies Speler:</h1>
            <c:if test="${requestScope.label != null}">
                <p class="label"><c:out value="${requestScope.label}"/></p>
            </c:if>
            <form method="POST" action="GameInit">
                <c:forEach begin="1" end="${requestScope.aantal}" >
                    
                    <select name="spelers">
                        <c:forEach items="${sessionScope.allplayers}" var="player" varStatus="count">
                            <option value="${count.index.toString()}">${player.getNickname()}</option>
                        </c:forEach>
                    </select>
                        
                      
                </c:forEach><br><br><br>
                <input type="submit" value="start spel"/>

            </form>
            <c:if test="${requestScope.nocreditplayers.size() > 0}">
                <p style="color:red;">volgende spelers hebben geen credits meer</p>
                <ul>
                <c:forEach items="${requestScope.nocreditplayers}" var="player">
                    <li>${player.getNickname()}</li>
                </c:forEach>
                </ul>
            </c:if>  
        </div>
    </body>
</html>
