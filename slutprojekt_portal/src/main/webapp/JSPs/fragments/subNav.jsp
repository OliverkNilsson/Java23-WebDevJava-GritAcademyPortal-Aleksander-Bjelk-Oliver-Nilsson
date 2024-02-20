<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-16
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Grit Academy Portal</title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>


<c:if test="${usersBean.privilageType == 'admin'}">
<nav id="subnav">
    <a href="/registerTeachers" class="registerteachers" title="registerTeachers">Register Teachers</a>
    <a href="/registerStudents" class="registerstudents" title="registerStudents">Register Students</a>
</nav>
</c:if>

</body>
</html>