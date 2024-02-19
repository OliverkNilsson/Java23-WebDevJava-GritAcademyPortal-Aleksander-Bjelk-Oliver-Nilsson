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

<h2 class="subHeader" id="subHeadertext">Courses</h2>

<c:if test="${empty sessionScope.usersBean}">
    <%@ include file="fragments/navAno.jsp"%>
</c:if>

<c:if test="${not empty sessionScope.usersBean}">
    <%@ include file="fragments/navCon.jsp"%>
</c:if>
<div class="generalpicture">
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
</div>
<%@ include file="fragments/footer.jsp"%>
</body>
</html>

