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


<div class="center">
    <form action="/userpage" method="post">
        <select id="user_type" name="courseId">
            <c:forEach items="${courses}" var="dataC">
                <option value="${dataC[0]}">${dataC[1]}</option>
            </c:forEach>
        </select>
        <input type="submit" id="studentSubmit" name="studentSubmitButton" value="Show Course details">
        <button onclick=location.href='/userpage'>Go Back</button>
    </form>
</div>



</body>
</html>
