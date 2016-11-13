<%-- 
    Document   : wachtwoordWijzigen
    Created on : Nov 6, 2016, 7:24:31 PM
    Author     : Gebruiker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/opties.css" type="text/css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wachtwoord wijzigen</title>
        <style type="text/css">
            
            form:nth-of-type(1)>input{
                padding:10px;
                color:white;    
            }
            form:nth-of-type(1)>input:nth-of-type(2){
                margin-left: 0px;
                padding:10px;
            }
            form:nth-of-type(1)>input:hover{
                margin-left: 0px;
                border-radius: 20px;
                cursor: auto;
                background-color: black;
                
            }
            form:nth-of-type(1)>input:nth-of-type(2):hover{
                margin-left: 0px;
                cursor: auto;
                background-color: black;
                color:white;
            }
            form button{
                margin-left: 55px;
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
            form button:hover{
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
            }
          
        </style>
    </head>

    <body background="images/background/darth-vader.jpg"    >
        <%
            if(session.getAttribute("email")==null)
            {
                response.sendRedirect("login.jsp");
            }
        %>
        <h3>Opties</h3>
        <h2 align="center">WachtWoord Wijzigen</h2><br><br><br><br><br>
        <form method="POST" action="WachtwoordWijzigenServlet">
            <input  type="text" name="email" placeholder="Vul email in" required><br><br>
            <input type="password" name="oudWachtwoord" placeholder="Vul oud wachtwoord in" required><br><br>
            <input type="password" placeholder="Vul Nieuw Wachtwoord" id="password" name="nieuwWachtwoord" required><br><br>
            <input type="password" placeholder="Bevestig Wachtwoord" id="confirm_password" name="confirmPassword" required><br><br>
            <p style="color:red;">${errorConfirmed}</p>
            <button type="submit" class="pure-button pure-button-primary">OK</button>
        </form>

            <aside>
            <input type="button" value="Speler Aanmaken" onclick="location.href='spelerAanmaken.jsp';"><br><br>
            <input type="button" value="Speler Verwijderen" onclick="location.href='spelerVerwijderen.jsp';"><br><br>
            <input type="button" value="Credits Wijzigen" onclick="location.href='creditsWijzigen.jsp';"><br><br>
            <input type="button" value="Wachtwoord Wijzigen" onclick="location.href='wachtwoordWijzigen.jsp';"><br><br>
            <input type="button" value="Historiek" onclick="location.href='historiek.jsp';"><br><br>
            <input type="button" value="Beheer Afsluiten" name="afsluiten" onclick="location.href='index.jsp';">
           
        </aside>
    </body>
</html>
