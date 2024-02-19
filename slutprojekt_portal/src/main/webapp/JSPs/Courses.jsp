<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-16
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Alla kurser</title>
</head>
<body>
<%@ include file="fragments/header.jsp"%>

<c:if test="${empty sessionScope.usersBean}">
    <%@ include file="fragments/navAno.jsp"%>
</c:if>

<c:if test="${not empty sessionScope.usersBean}">
    <%@ include file="fragments/navCon.jsp"%>
</c:if>

<table>

    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course[0]}</td>
            <td>${course[1]}</td>
            <td>${course[2]}</td>
            <td>${course[3]}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="fragments/footer.jsp"%>
</body>
</html>

