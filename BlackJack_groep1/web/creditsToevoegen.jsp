<%-- 
    Document   : creditsToevoegen
    Created on : 27-okt-2016, 10:17:03
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            select{
           display: block;
           margin: auto;
            }
        </style>
    </head>
    <body>
        <h3 style="font-size: 50px">Beheerder</h3>
                        <h2 align="center">Credits Toevoegen</h2>
        <form action="creditsServlet" method="post">   
          <select name="credit">
            <option value="1">10</option>
            <option value="2">50</option>
            <option value="3">100</option>
            <option value="4">500</option>
          </select>
            <br/>
            <div class="e" align="center">
            <input type="submit" value="Aantal Credits Toevoegen">
            </div>
        </form>
        
        <div class="f">
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
        
            </div>

    </body>
</html>
