<%-- 
    Document   : login
    Created on : Nov 12, 2016, 10:27:12 PM
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/loginStyle/style.css">
        <title>Login</title>
    </head>
    <body>
        <button onclick="location.href='index.jsp'">Hoofdpagina</button>
         <div class="login">
            <div class="login-screen">
                <div class="app-title"><h1>Aanmelden</h1></div>
                <form class="login-form" method="POST" action="LoginServlet"><div class="control-group"> <input type="text" name="username" placeholder="emailadres" required></div>
                    ${errormessage}
                    <div class="control-group">  <input type="password" name="password" placeholder="wachtwoord" required></div>
                    <button class="btn" type="submit" name="login_btn">Aanmelden</button>
                </form>
                <a href="registerAdmin.jsp">Registreer</a>
            </div>
        </div>
    </body>
</html>
