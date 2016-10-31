<%-- 
    Document   : spelerAanmaken
    Created on : 27-okt-2016, 10:16:30
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
            form:nth-of-type(1){
                width: 150px;
                margin-left:auto;
                margin-right: auto;
           
            }
            form:nth-of-type(1)>input:nth-of-type(2){
                margin-left: 30px;
            }
            aside{
               position: absolute;
               top: 273px;
            }
        </style>
    </head>
    <body>
        <h3 style="font-size: 50px">Beheerder</h3>
        <h2 align="center">Speler Aanmaken</h2>
       
        <form>
             <p align="center">Naam Speler:</p>
             <input type="text" value="naam">
             <br><br>
               <input  type="submit" value="Toevoegen">
        </form>
         <aside>
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
        </aside>
    </body>
</html>
