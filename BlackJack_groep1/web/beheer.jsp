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
            
            aside{
               position: absolute;
               top: 273px;
            }
        </style>    
    </head>
    <body>
        
        <h3 style="font-size: 50px">Beheerder</h3><br><br><br><br><br><br>
        <aside>
            <input type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Toevoegen" onclick="location.href='creditsToevoegen.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.html';">
        </aside>
        
    </body>
</html>
