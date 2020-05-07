
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../styles/styles.css" type="text/css"/>
        <title>TITA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>TITA</h1>
        <!--original-->
        <ul class="navigation">
            <li><a href="../index.jsp">Home</a></li>
            <li><a href="../new_customer.jsp">Sign Up</a></li>
            <li><a href="../login.jsp">User Login</a></li>  
        </ul>


        <br>
        
       
<!--        <ul class="navigation">
            <li><a href="index.jsp">Home</a></li>
            <li><a href="new_customer.jsp">Sign Up</a></li>
            <li><a href="login.jsp">User Login</a></li>  
        </ul>-->
        
        

<form action="../ReportsServlet" method="post">
<!--<form action="ReportsServlet" method="post">-->
    <input type="hidden" name="action"> 
    <input type="submit" name="reports" value="Get user names">
</form>
        <br>
<form action="../RequestSpreadsheet" method="post">
<!--<form action="RequestSpreadsheet" method="post">-->
    <input type="hidden" name="action"> 
    <input type="submit" name="spreadsheet" value="Get spreadsheet">
</form>
        <!--works-->
        <%--
        <c:forEach var="user" items="${sessionScope.user}">
            <p>${user.firstName} ${user.lastName}</p>
            <hr>
        </c:forEach>
        --%>

        <c:forEach var="user" items="${user}">
            <p>${user.firstName} ${user.lastName}</p>
            <hr>
        </c:forEach>
         

            <br><br>
<%@ include file="/includes/footer.jsp" %>
