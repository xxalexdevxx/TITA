<%@ include file="/includes/header.html" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <p>Hello, ${sessionScope.user.firstName} ${sessionScope.user.lastName}</p>
    </c:when>
    <c:otherwise>
        <h2>Not logged in</h2>
    </c:otherwise>
</c:choose>

<h1>Dashboard</h1>
        <h1>${formMessage}</h1>
        <p style="font-weight: bold;">Issue Summary:</p>
        <p>${sessionScope.issue.issueSummary}</p>
        <p style="font-weight: bold;">Assigned Owner:</p>
        <p>${sessionScope.issue.assignedOwner}</p>
        <p style="font-weight: bold;">Issue Status:</p>
        <p>${sessionScope.issue.issueStatus}</p>
        <p style="font-weight: bold;">Issue Created Date:</p>
        <p>${sessionScope.issue.issueCreatedDate}</p>
        <p style="font-weight: bold;">Estimated Effort:</p>
        <p>${sessionScope.issue.estimatedEffort}</p>
        <p style="font-weight: bold;">Estimated Completion Date:</p>
        <p>${sessionScope.issue.estimatedCompletionDate}</p><br><br>

<%@ include file="/includes/footer.jsp" %>