<%@ include file="/includes/header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Issue</h1>
        <h1>${formMessage}</h1>
        
        <%-- <form action="<c:url value='/issue/new_issue'/>" method="post"> --%>
        <form action="IssueServlet" method="post">
            <input type="hidden" name="action" value="create">  
            <label for="issueSummary">Issue Summary:</label><br>
            <input type="textarea" id="issueSummary" name="issueSummary"><br><br>
            <label for="issueStatus">Issue Status:</label><br>
            <select id="issueStatus" name="issueStatus">
                    <option value="INCOMPLETE">Incomplete</option>
                <option value="COMPLETE">Complete</option>
            </select><br><br>
            <label for="estimatedEffort">Estimated Effort (number of days):</label><br>
            <input type="number" id="estimatedEffort" name="estimatedEffort"><br><br>
            <label for="estimatedCompletionDate">Estimated Completion Date:</label><br>
            <input type="date" id="estimatedCompletionDate" name="estimatedCompletionDate"><br><br>
            <input type="submit" value="Submit">
        </form> 
        
<%@ include file="/includes/footer.jsp" %>