<%-- 
    Document   : spelerAanmaken
    Created on : 27-okt-2016, 10:16:30
    Author     : MSI
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Icon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hitek.prog3.db.service.IconService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link href="css/opties.css" type="text/css" rel="stylesheet">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body background="images/background/darth-vader.jpg">
        <%
            if(session.getAttribute("email")==null)
            {
                response.sendRedirect("login.jsp");
            }
            %>
        <h3>Opties</h3>
        <h2 align="center">Speler Aanmaken</h2>
        <form action="spelerAanmakenServlet" method="post">
             <p align="center">Naam Speler:</p>
             <input type="text" name="naam" required>
             <p align="center">Kies Icoon:</p>
             <select name="icoon">
            <%
                IconService icon = new IconService();
                List<Icon> result = icon.getAllIcon();
                Iterator<Icon> iterator= result.iterator();
              while(iterator.hasNext()){
                  String naam = iterator.next().getNaam();
                   out.write("<option value='"+ naam +"'>");
                   out.write(""+naam+"");
                   out.write("</option>"); 
                   out.write("<br>");
                }
            %>
          </select>
             <br><br>
               <input type="submit" value="Aanmaken"><br><br>
        </form>
          <div align="center">
            ${b}
          </div>
         <aside>
            <input  type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Wijzigen" onclick="location.href='creditsWijzigen.jsp';"><br><br>
            <input type="button" value="Wachtwoord Wijzigen" onclick="location.href='wachtwoordWijzigen.jsp';"><br><br>
            <input type="button" value="Historiek" onclick="location.href='historiek.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.jsp';"><br><br>
        </aside><br><br>
          
    </body>
</html>
