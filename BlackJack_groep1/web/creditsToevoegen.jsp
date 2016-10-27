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
            input{
                position: absolute;
            }
            select{
                margin-left:  45%;
            }
            
        </style>
    </head>
    <body>
        <h3 style="font-size: 50px">Beheerder</h3>
        <h2 align="center">Credits Toevoegen</h2>
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
        <form>   
          <select name="gebruikers">
            <option value="">10</option>
            <option value="">50</option>
            <option value="">100</option>
            <option value="">500</option>
          </select>
            <br><br><br>
            <div align="center">
            <input type="submit" value="Aantal Credits Toevoegen">
            </div>
        </form>
        
    </body>
</html>
