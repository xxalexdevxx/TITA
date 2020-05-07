<%@ include file="/includes/header.html" %>
        <br>
        <br>
        <%--
        <h1>User account has been successfully created.</h1>
        <p>${sessionScope.user.firstName}</p>
        <p>${sessionScope.user.lastName}</p>
        <p>${sessionScope.user.email}</p>
        <p>${sessionScope.user.userName}</p>
        <p>${sessionScope.user.password}</p>
        <p>${sessionScope.user.zipcode}</p>
        --%>
        
        <h1>User account has been successfully created.</h1>
        <p>${sessionScope.userLoggedIn.firstName}</p>
        <p>${sessionScope.userLoggedIn.lastName}</p>
        <p>${sessionScope.userLoggedIn.email}</p>
        <p>${sessionScope.userLoggedIn.userName}</p>
        <p>${sessionScope.userLoggedIn.password}</p>
        <p>${sessionScope.userLoggedIn.zipcode}</p>
     
<%@ include file="/includes/footer.jsp" %>
