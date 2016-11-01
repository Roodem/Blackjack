<%-- 
    Document   : spelerAanmaken
    Created on : 27-okt-2016, 10:16:30
    Author     : MSI
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Icon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hitek.prog3.db.service.IconService"%>
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
        <script type="text/javascript">
            function btnOnClick() {
                alert('SPELER WERD TOEGVOEGD!');
            }
        </script>
    </head>
    <body>
        <h3 style="font-size: 50px">Beheerder</h3>
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
            %>        
                <option><%=iterator.next()%></option>
           <%         
                }
            %>
          </select>
             <br><br>
               <input type="submit" value="Toevoegen" onclick="javascript:btnOnClick()">
        </form>
         <aside>
            <input  type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Toevoegen" onclick="location.href='creditsToevoegen.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.html';">
        </aside>
    </body>
</html>
