<%-- 
    Document   : registerAdmin
    Created on : Nov 12, 2016, 7:25:42 PM
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registreer</title>
    </head>
    <body>
         <form method="POST" action="RegisterAdminServlet">
             <input type="text" name="name" placeholder="naam" required><br>
            <input type="text" name="email" placeholder="email" required><br>
            <input type="password" placeholder="Wachtwoord" id="password" name="nieuwWachtwoord" required>
            <input type="password" placeholder="Bevestig Wachtwoord" id="confirm_password" required>

            <button type="submit" class="pure-button pure-button-primary">Registreer</button>
        </form>
    </body>
</html>
