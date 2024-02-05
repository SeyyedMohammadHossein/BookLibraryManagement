<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main menu</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="container">
<div class="center">
    <a href="create-user.jsp" class="btn">
        <button type="button" class="button" value="create user">create user</button>
    </a>
    <a href="get-user.jsp" class="btn">
        <button type="button" class="button" value="get user">get user</button>
    </a>
    <br>
    <a href="get_list_of_users_servlet" class="btn">
        <button type="button" class="button" value="get list of users">get list of users</button>
    </a>
    <a href="delete-user.jsp" class="btn">
        <button type="button" class="button" value="delete user">delete user</button>
    </a>
    <br>
    <a href="get_list_of_books_servlet" class="btn">
        <button type="button" class="button" value="get list of books">get list of books</button>
    </a>
    <br>
</div>
</body>
</html>