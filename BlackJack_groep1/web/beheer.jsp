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
            input{
                position: absolute;
            }
        </style>    
    </head>
    <body>
        
        <h3 style="font-size: 50px">Beheerder</h3><br><br><br><br><br><br>
        <form action="spelerAanmakenServlet" method="post">
            <input  type="submit" value="Speler Aanmaken">
        </form><br><br>
        
        <form action="spelerVerwijderenServlet" method="post">
            <input type="submit" value="Speler Verwijderen">
        </form><br><br>
        
        <form action="creditsToevoegenServlet" method="post">
            <input type="submit" value="Credits Toevoegen">
        </form><br><br>
        
        <form action="beheerAfsluitenServlet" method="post">
            <input type="submit" value="Beheer Afsluiten">
        </form> 
        
    </body>
</html>