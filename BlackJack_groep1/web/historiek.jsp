<%-- 
    Document   : Historiek
    Created on : Nov 5, 2016, 5:38:16 PM
    Author     : Gebruiker
--%>

<%@page import="com.hitek.prog3.db.service.HistoriekService"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Player"%>
<%@page import="com.hitek.prog3.db.service.PlayerService"%>
<%@page import="com.hitek.prog3.db.util.DatabaseSingleton"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/opties.css" type="text/css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            form input{
                margin-left: 0px;
                cursor: pointer;
                background-color: transparent;
                color: white;
                border: 3px solid;
                border-color: silver;
                text-align: center;
                outline: none;
                -webkit-transition-duration: 0.8s; /* Safari */
                transition-duration: 0.8s;
            }
            form input:hover{
                border-radius: 20px;
                background-color: darkgray;
                color:black;
                border-color: white;
                padding-bottom: 5px;
                padding-left: 5px;
                padding-right: 5px;
                padding-top: 5px;
                font-weight: bold;
                -webkit-transition-duration: 0.8s; /* Safari */
                transition-duration: 0.3s;
                
                margin-top: -5px;
            }
            form input{
                float: right;
            }
            form select{
                float: left;
            }
            
        </style>
    </head>
    <body background="images/background/darth-vader.jpg" >
        <h3>Opties</h3>
        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        
        
        
        
        <h3 style="text-decoration:underline;" align=center>HISTORIEK</h3>
            <%
                ResultSet rs = HistoriekService.volledigHistoriekWeergeven();
                int count  = 0;
            %>
                <TABLE align="center" style="width:30%; border-color:silver;" BORDER="1">
                    <TR >
                        <TH>GAME ID</TH>
                        <TH>DATUM</TH>
                        <TH>BALANCE</TH>
                    </TR>
                    <% while (rs.next() && count <= 8) {%>
                    <TR>
                        <TD align="center"> <%= rs.getInt("GamegameId")%></TD>
                        <TD align="center"> <%= rs.getString("Playernickname")%></TD>
                        <TD align="center"> <%= rs.getString("balance")%></TD>
                    </TR>
                    <% count++; } %>
                </TABLE><br><br>
            
        <form action="HistoriekServlet" method="post">        
            <div style=" width: 150px;" align="center">
                    <select name="naam">  
                        <%
                            PlayerService sor = new PlayerService();
                            List<Player> result = sor.getAllPlayersName();
                            Iterator<Player> iterator = result.iterator();
                            while (iterator.hasNext()) {
                                String naam = iterator.next().getNickname();
                                out.write("<option value='" + naam + "'>");
                                out.write("" + naam + "");
                                out.write("</option>");
                                out.write("<br>");
                            }

                        %>
                    </select>
                    <input type="submit" value="OK"/>
            </div>

        </form>
        <br><br><br> 
        
        
        <TABLE align="center" BORDER="1" style="width: 30%; ">
            <TR>
                <TH>GAME ID</TH>
                <TH>DATUM</TH>
                <TH>BALANCE</TH>
            </TR>

            <c:forEach items="${itarator}" >
                <TR>
                    <td align="center"><c:out value="${itarator.next()}"></c:out></td>   
                    <td align="center"><c:out value="${itarator.next()}"></c:out></td>   
                    <td align="center"><c:out value="${itarator.next()}"></c:out></td>   
                    </tr>
            </c:forEach>    


        </TABLE>
        <aside>
            <input type="button" value="Speler Aanmaken" onclick="location.href = 'spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href = 'spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Wijzigen" onclick="location.href = 'creditsWijzigen.jsp';"><br><br>
            <input type="button" value="Wachtwoord Wijzigen" onclick="location.href = 'wachtwoordWijzigen.jsp';"><br><br>
            <input type="button" value="Historiek" onclick="location.href = 'historiek.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" onclick="location.href = 'index.jsp';">
        </aside>
    </body>
</html>
