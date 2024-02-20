<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-16
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
<%@ include file="fragments/header.jsp"%>
<h2 class="subHeader" id="subHeadertext">User Page</h2>
<%@ include file="fragments/navCon.jsp"%>
<%@ include file="fragments/subNav.jsp"%>

<c:if test = "${usersBean.userType == 'student'}">
<%@ include file="fragments/student/studentUserPage.jsp"%>
</c:if>
<c:if test = "${usersBean.userType == 'teacher'}">
<%@ include file="fragments/teachers/teacherUserPage.jsp"%>
</c:if>
<%@ include file="fragments/footer.jsp"%>

</body>
</html>
