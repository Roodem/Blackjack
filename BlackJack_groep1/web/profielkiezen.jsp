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
            #container{
                border: black 1px dotted; width: 950px; height:600px; margin-left: auto; margin-right: auto;
            }

            #profile{
                border: dotted black 1px;
                height: 200px;
                width: 200px;
            }
            .label{
                color: red;
                font: 9px;
            }
        </style>

    </head>
    <body>
        <div id="container">
            <h1>BlackJack spelerprofiel kiezen</h1>
            <c:if test="${requestScope.label != null}">
                <p class="label"><c:out value="${requestScope.label}"/></p>
            </c:if>
            <form method="POST" action="">
                <c:forEach begin="1" end="${requestScope.aantal}" >
                    
                    <select name="spelers">
                        <c:forEach items="${requestScope.allplayers}" var="player" varStatus="count">
                            <option value="${count.index.toString()}">${player.getNickname()}</option>
                        </c:forEach>
                    </select>
                        
                    <input type="submit" value="kies" />    
                </c:forEach>
                <input type="submit" value="start spel"/>

            </form>

        </div>
    </body>
</html>
