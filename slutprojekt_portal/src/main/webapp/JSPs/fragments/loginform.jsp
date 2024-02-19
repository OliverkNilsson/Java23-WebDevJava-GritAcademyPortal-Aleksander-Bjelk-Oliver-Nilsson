<%--
  Created by IntelliJ IDEA.
  User: aleksanderbjelk
  Date: 2024-02-16
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Grit Academy Portal</title>
</head>
<body>

<form id="loginForm" action="/login" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br><br>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br><br>
    <label for="user_type" name="user_type"></label>
        <select id="user_type" name="user_type">
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
        </select>
    <input type="submit" id="loginSubmit" name="loginSubmit" value="Log In">
</form>

</body>
</html>
