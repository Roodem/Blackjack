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
        <link rel="stylesheet" href="css/registerStyle/style.css">
    </head>
    <body>
        <button onclick="location.href='index.jsp'">Hoofdpagina</button>
         <form method="POST" action="RegisterAdminServlet" class="login">
             <input type="text" name="name" placeholder="naam" required><br>
            <input type="text" name="email" placeholder="email" required><br>
            ${errormessage}<br>
            <input type="password" placeholder="Wachtwoord" id="password" name="nieuwWachtwoord" required>
            <input type="password" placeholder="Bevestig Wachtwoord" id="confirm_password" name="confirmPassword" required>
            ${errorConfirmed}<br>
            <button id="register" type="submit" class="pure-button pure-button-primary">Registreer</button>
            <a href="login.jsp">Hebt u al een account?</a>
            
            <p>${errorMaxAdmin}</p><br>
        </form>
    </body>
</html>
