<%@ include file="/includes/header.html" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${sessionScope.userLoggedIn != null}">
        
        <h3><a href="new_issue.jsp">Create an Issue</a></h3>
        <h3><a href="delete_issue.jsp">Delete an Issue</a></h3>
    </c:when>
    <c:otherwise>
        <h2>Not logged in</h2>
    </c:otherwise>
</c:choose>

<h1>Dashboard</h1>

<!--        <h1>${formMessage}</h1>

        <!--code to iterate through list of issues-->
        <h3>Issues assigned to user:</h3>

 
        <c:forEach var="issue" items="${sessionScope.userLoggedIn.issues}">
            <p style="font-weight: bold;">Issue Id:</p>
            <p>${issue.issueId}</p>
            <p style="font-weight: bold;">Issue Summary:</p>
            <p>${issue.issueSummary}</p>
            <p style="font-weight: bold;">Assigned User:</p>
            <p>${issue.issueStatus}</p>
            <p style="font-weight: bold;">Issue Status:</p>
            <p>${issue.issueCreatedDate}</p>
            <p style="font-weight: bold;">Issue Created Date:</p>
            <p>${issue.estimatedEffort}</p>
            <p style="font-weight: bold;">Estimated Effort:</p>
            <p>${issue.estimatedCompletionDate}</p><br><br>
            <hr>
        </c:forEach>
       
        


<%@ include file="/includes/footer.jsp" %>


<!--CODE FROM ASSIGNMENT 2, SINGLE ISSUE DISPLAY-->
<!--        <h1>${formMessage}</h1>
        <p style="font-weight: bold;">Issue Summary:</p>
        <p>${sessionScope.issue.issueSummary}</p>
        <p style="font-weight: bold;">Assigned User:</p>
        <p>${sessionScope.issue.assignedUser}</p>
        <p style="font-weight: bold;">Issue Status:</p>
        <p>${sessionScope.issue.issueStatus}</p>
        <p style="font-weight: bold;">Issue Created Date:</p>
        <p>${sessionScope.issue.issueCreatedDate}</p>
        <p style="font-weight: bold;">Estimated Effort:</p>
        <p>${sessionScope.issue.estimatedEffort}</p>
        <p style="font-weight: bold;">Estimated Completion Date:</p>
        <p>${sessionScope.issue.estimatedCompletionDate}</p><br><br>-->