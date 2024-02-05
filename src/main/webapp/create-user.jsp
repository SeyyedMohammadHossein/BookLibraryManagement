<%--
  Created by IntelliJ IDEA.
  User: Win11
  Date: 2/6/2024
  Time: 1:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create user</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="container">
<form action="create_user_servlet" class="center" method="post">
    <p>
        <input type="text" name="name" placeholder="your name" class="txtInput">
    </p>
    <p>
        <input type="email" name="email-address" placeholder="email address" class="txtInput">
    </p>
    <p>
        <input type="password" name="password" placeholder="password" class="txtInput">
    </p>
    <button type="submit" class="button" value="submit">submit</button>
    <br>
    <a href="index.jsp" class="btn">
        <button type="button" class="button" value="back to main menu">back to main menu</button>
    </a>
</form>
</body>
</html>
