<%-- 
    Document   : wachtwoordWijzigen
    Created on : Nov 6, 2016, 7:24:31 PM
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wachtwoord wijzigen</title>
    </head>

    <body>
        <%
            if(session.getAttribute("email")==null)
            {
                response.sendRedirect("login.jsp");
            }
            %>
        <form method="POST" action="WachtwoordWijzigenServlet">
            <input type="text" name="email" placeholder="email" required><br>
            <input type="password" name="oudWachtwoord" placeholder="oud wachtwoord" required><br>
            <input type="password" placeholder="Nieuw Wachtwoord" id="password" name="nieuwWachtwoord" required>
            <input type="password" placeholder="Bevestig Wachtwoord" id="confirm_password" required>

            <button type="submit" class="pure-button pure-button-primary">Wijzig wachtwoord</button>
        </form>

    </body>
</html>
