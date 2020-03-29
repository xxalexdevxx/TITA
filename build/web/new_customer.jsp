<%-- 
    Document   : new_customer
    Created on : Mar 28, 2020, 4:07:44 PM
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/styles.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TITA</title>
    </head>
    <body>
        <h1>TITA</h1>
        <ul class="navigation">
            <li><a href="index.html">Home</a></li>
            <li><a href="new_customer.jsp">New Customer Sign Up</a></li>
            <li><a href="login.html">Login</a></li>
        </ul>
        <br>
        <br>
        <h1>${formMessage}</h1>
        <form action="RegistrationServlet" method="post">
            <input type="hidden" name="action">  
            <label for="firstName">First name:</label><br>
            <input type="text" id="firstName" name="firstName"><br>
            <label for="lastName">Last name:</label><br>
            <input type="text" id="lastName" name="lastName"><br><br>
            <label for="lastName">Email:</label><br>
            <input type="text" id="email" name="email"><br><br>
            <label for="lastName">User Name:</label><br>
            <input type="text" id="userName" name="userName"><br><br>
            <label for="lastName">Password:</label><br>
            <input type="text" id="password" name="password"><br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
