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
    <form action="/userpage" method="POST">
        <label for="lang">Language</label>
        <select name="languages" id="lang">
            <option value="javascript">JavaScript</option>
            <option value="php">PHP</option>
            <option value="java">Java</option>
            <option value="golang">Golang</option>
            <option value="python">Python</option>
            <option value="c#">C#</option>
            <option value="C++">C++</option>
            <option value="erlang">Erlang</option>
        </select>
        <input type="submit" value="Show details" name="studentCoursesButton" />
    </form>

</div>


</body>
</html>
