<%@ include file="/includes/header.html" %>
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
            <label for="lastName">Zipcode</label><br>
            <input type="text" id="zipcode" name="zipcode"><br><br>
            <input type="submit" value="Submit">
        </form> 
<%@ include file="/includes/footer.jsp" %>
