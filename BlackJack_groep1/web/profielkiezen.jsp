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
            body{
                color: yellow; 
                    
            }
            #container{
                border: yellow 5px solid;
                width: 1200px;
                height:800px; 
                margin:auto;
                padding: 20px;
                border-radius: 25px;
                background-image: url("images/background/darth-vader.jpg");
                background-size: contain;
            }

           
            .label{
                color: red;
                
            }
        </style>

    </head>
    <body>
        <div id="container">
            <h1>BlackJack spelerprofiel kiezen</h1>
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
                        
                      
                </c:forEach>
                <input type="submit" value="start spel"/>

            </form>
            <c:if test="${requestScope.nocreditplayers.size() > 0}">
                <p>volgende spelers hebben geen credits meer</p>
                <ul>
                <c:forEach items="${requestScope.nocreditplayers}" var="player">
                    <li>${player.getNickname()}</li>
                </c:forEach>
                </ul>
            </c:if>  
        </div>
    </body>
</html>
