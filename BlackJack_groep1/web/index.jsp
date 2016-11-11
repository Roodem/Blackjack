<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Blackjack</title>
         <link rel="stylesheet" href="css/indexStyle/style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        <div>
            <a href="help.html"><img id="help" src="./images/etc/help.png" alt="help"/></a>
            <form id="login" action="login.html"><button name="btn_login" value="adminlogin">Aanmelden</button></form>
        </div>

        <div id="container">
            <h1>BLACKJACK</h1>

            <div>
                <h2>aantal spelers kiezen</h2>  
                <form action="AantalSpelersServlet" method="POST">
                    <select name="aantalspelers">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                    <input type="submit" value="kies"/>
                </form>
            </div>
            <c:if test="${requestScope.warning}">
                <p class="warning">Iedereen moet een ander profiel kiezen</p>
            </c:if>
                 <c:if test="${requestScope.noplayernocredits}">
                <p class="warning">Niemand heeft nog credits</p>
            </c:if>
            
        </div>
        <a href="beheer.jsp">BEHEER</a>
    </body>
</html>
