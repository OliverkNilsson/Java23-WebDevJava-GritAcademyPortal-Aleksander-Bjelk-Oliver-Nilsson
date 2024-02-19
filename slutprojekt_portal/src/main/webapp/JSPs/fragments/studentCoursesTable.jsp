<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-19
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:if test="${empty sessionScope.usersBean}">
    <%@ include file="navAno.jsp"%>
</c:if>

<c:if test="${not empty sessionScope.usersBean}">
    <%@ include file="navCon.jsp"%>
</c:if>


<div class="generalpicture">


</div>


</body>
</html>
