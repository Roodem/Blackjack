<%-- 
    Document   : spelerVerwijderen
    Created on : 27-okt-2016, 10:16:45
    Author     : MSI
--%>

<%@page import="model.Player"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hitek.prog3.db.service.PlayerService"%>
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
            aside{
               position: absolute;
               top: 273px;
            }
        </style>
        <script type="text/javascript">
            function btnOnClick() {
                alert('SPERLER WERD VERWIJDERD!');
            }
        </script>
    </head>
    <body>
        <h3 style="font-size: 50px">Beheerder</h3>
        <h2 align="center">Speler Verwijderen</h2>
        <form action="spelerVerwijderenServlet" method="post">   
          <select name="naam">
            <%
                PlayerService sor = new PlayerService();
                ArrayList<Player> result = sor.getAllPlayersName();
                Iterator<Player> iterator= result.iterator();
              while(iterator.hasNext()){
            %>        
                <option><%=iterator.next()%></option>
           <%         
                }
                
            %>
          </select>
            <br/>
            <div align="center">
            <input type="submit" value="Verwijder Speler" onclick="javascript:btnOnClick()">
            </div>
        </form>
        <aside>
            <input  type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Toevoegen" onclick="location.href='creditsToevoegen.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.html';">
        </aside>
    </body>
</html>
