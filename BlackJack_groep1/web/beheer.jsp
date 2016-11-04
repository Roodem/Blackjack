<%-- 
    Document   : beheerderAccount
    Created on : 26-okt-2016, 11:05:33
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-size:cover; 
                background-repeat: no-repeat;
            }
            aside{
               position: absolute;
               top: 273px;
            }
            h3{
                font-size: 50px;
                color:red
            }
            
            p{
                font-size: 30px;
                color:white;
            }
        </style>    
    </head>
    <body background="images/background/background_beheerder2.jpg">
        
        <h3>Opties</h3><br><br><br><br><br><br>
        <aside>
            <input type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Wijzigen" onclick="location.href='creditsWijzigen.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.jsp';">
        </aside>
        
    </body>
</html>
