<%@ include file="/includes/header.html" %>
        <form action="LoginServlet" method="post">
            <input type="hidden" name="action">  
            <label for="userName">User name:</label><br>
            <input type="text" id="userName" name="userName"><br>
            <label for="password">Password:</label><br>
            <input type="text" id="password" name="password"><br><br>
            <input type="submit" value="Submit">
        </form> 
<%@ include file="/includes/footer.jsp" %>
