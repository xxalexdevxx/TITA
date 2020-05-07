<%@ include file="/includes/header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Delete an issue</h3>
        <form action="IssueServlet" method="post">
            <input type="hidden" name="action" value="delete">  
            <label for="issueId">Issue Id: </label><br>
            <input type="number" id="issueId" name="issueId"><br><br>
            <input type="submit" value="Submit">
        </form> 

<%@ include file="/includes/footer.jsp" %>