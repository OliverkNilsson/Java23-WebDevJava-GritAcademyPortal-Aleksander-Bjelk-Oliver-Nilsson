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