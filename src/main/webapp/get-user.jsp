<%--
  Created by IntelliJ IDEA.
  User: Win11
  Date: 2/6/2024
  Time: 2:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>get user</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="container">
<form action="get_user_servlet" class="center" method="get">
    <p>
        <input type="text" name="user-id" placeholder="user id" class="txtInput">
    </p>
    <button type="submit" class="button" value="search">search</button>
    <br>
    <a href="index.jsp" class="btn">
        <button type="button" class="button" value="back to main menu">back to main menu</button>
    </a>
</form>
</body>
</html>
