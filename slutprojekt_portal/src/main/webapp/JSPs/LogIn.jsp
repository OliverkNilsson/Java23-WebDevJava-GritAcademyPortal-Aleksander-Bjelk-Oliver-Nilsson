<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-16
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
<%@ include file="fragments/header.jsp" %>
<h2 class="subHeader" id="subHeadertext">Log In</h2>
<%@ include file="fragments/navAno.jsp" %>

<div class="generalpicture">
    <c:if test="${not empty errorMessage}">
    <div class="error-message">${errorMessage}

        </c:if>
        <%@ include file="fragments/loginform.jsp" %>
    </div>
</div>
<%@ include file="fragments/footer.jsp" %>


</body>
</html>
