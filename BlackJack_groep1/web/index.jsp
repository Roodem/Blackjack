<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Blackjack</title>
  
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
           @font-face{
                font-family: starwars;
                src:url('css/fonts/OptimusPrincepsSemiBold.ttf');
            }
            body{
              background-color: black;
            }
            section{
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
                background: url("images/background/background_index.jpg");
                background-size: 1300px;
                background-repeat: no-repeat;
            }
     
            .container{
                margin-top: 50px;
                width: 400px;
                margin-left: 400px;
                text-align: center;
            }
            a{
                font-size:55px;
               float: left;
               text-decoration: none;
               color:silver;
              font-family: "starwars";
       
            }
            a:hover{
                text-decoration: underline;
            }
           
            div:nth-of-type(1){
             float:right;   
            }
            h1, h2{
                color: silver;
                 font-family: "starwars";
            }
            section img{
                margin-top: 0px;
             width: 450px;
             margin-left: auto;
             margin-right: auto;
             display: block;
             clear: both;
            }
            .warning{
                margin-bottom: 20px;
                color:red;
            }
        </style>
        
    </head>
    <body>
     
        <section>
     
            <a href="help.html">?</a>
                   
            <div>
                <input type="button" value="BEHEER" onclick="location.href='beheer.jsp';">
        </div>
            
               <img src="images/background/background-starwars-logo.png">
            <div class="container">
                <h1>BLACKJACK</h1>
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
            
        <% session.invalidate();%>
       </section>
    </body>
</html>
