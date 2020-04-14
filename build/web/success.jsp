<%@ include file="/includes/header.html" %>
        <br>
        <br>
        <h1>Account has been successfully created.</h1>
        <p>${sessionScope.user.firstName}</p>
        <p>${sessionScope.user.lastName}</p>
        <p>${sessionScope.user.email}</p>
        <p>${sessionScope.user.userName}</p>
        <p>${sessionScope.user.password}</p>
        <p>${sessionScope.user.zipcode}</p>
     
<%@ include file="/includes/footer.jsp" %>
