<%-- 
    Document   : Historiek
    Created on : Nov 5, 2016, 5:38:16 PM
    Author     : Gebruiker
--%>

<%@page import="com.hitek.prog3.db.util.DatabaseSingleton"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
              <% 
            Statement stmt = null;
        Connection con = DatabaseSingleton.getDatabaseSingleton().getConnection(true);
           String query = "select post.ID, naam, datum, locatie \n "
                + " from post \n "
                + "join persoon \n "
                + "on OntvangerID = persoon.ID \n"
                + " order by datum DESC";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        %>
  <TABLE BORDER="1">
            <TR>
                <TH>DATUM</TH>
                <TH>SPELER</TH>
                <TH>WINST/VERLIES<TH>
            </TR>
            <% while(rs.next()){ %>
            <TR>
                <TD> <%= rs.getDate("datum") %></td>
                <TD> <%= rs.getString("speler") %></TD>
                <TD> <%= rs.getString("balance") %></TD>
            </TR>
            <% } %>
        </TABLE>
    </body>
</html>
