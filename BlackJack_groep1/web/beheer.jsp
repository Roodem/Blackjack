<%-- 
    Document   : beheerderAccount
    Created on : 26-okt-2016, 11:05:33
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/opties.css" type="text/css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
      <body background="images/background/darth-vader.jpg">
        
        <h3>Opties</h3><br><br><br><br><br><br>
        <aside>
            <input type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Wijzigen" onclick="location.href='creditsWijzigen.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.jsp';">
        </aside>
        
    </body>
</html>
