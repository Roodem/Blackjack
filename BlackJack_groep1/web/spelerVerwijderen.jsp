<%-- 
    Document   : spelerVerwijderen
    Created on : 27-okt-2016, 10:16:45
    Author     : MSI
--%>

<%@page import="java.util.List"%>
<%@page import="model.Player"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hitek.prog3.db.service.PlayerService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/opties.css" type="text/css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
        <script type="text/javascript">
            function btnOnClick() {
                alert('SPERLER WORD VERWIJDERD!');
            }
        </script>
    </head>
    <body background="images/background/darth-vader.jpg">
        <%
            if(session.getAttribute("email")==null)
            {
                response.sendRedirect("login.jsp");
            }
            %>
        <h3>Opties</h3>
        <h2 align="center">Speler Verwijderen</h2>
        <form action="spelerVerwijderenServlet" method="post">   
          <select name="naam">
            <%
                PlayerService sor = new PlayerService();
                List<Player> result = sor.getAllPlayersName();
                Iterator<Player> iterator= result.iterator();
                while(iterator.hasNext()){
                  String naam = iterator.next().getNickname();
                   out.write("<option value='"+ naam +"'>");
                   out.write(""+naam+"");
                   out.write("</option>"); 
                   out.write("<br>");
                }
                
            %>
          </select>
            <br/>
            <div align="center">
            <input type="submit" value="Verwijder" onclick="javascript:btnOnClick()">
            </div>
        </form>
        <aside>
            <input  type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Wijzigen" onclick="location.href='creditsWijzigen.jsp';"><br><br>
            <input type="button" value="Wachtwoord Wijzigen" onclick="location.href='wachtwoordWijzigen.jsp';"><br><br>
            <input type="button" value="Historiek" onclick="location.href='historiek.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href='index.jsp';">
        </aside>
    </body>
</html>
