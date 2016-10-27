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
        </style>

    </head>
    <body>
        <div id="container">
            <h1>BlackJack spelerprofiel kiezen</h1>
            <form method="POST" action="">
                <c:forEach begin="1" end="${requestScope.aantal}">
                    <select name="spelers">
                        <c:forEach begin="1" end="5">
                            <option value="test">test</option>
                        </c:forEach>   

                    </select>


                </c:forEach>
                <input type="submit" value="start spel"/>

            </form>

        </div>
    </body>
</html>
