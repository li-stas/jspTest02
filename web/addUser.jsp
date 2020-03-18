<%--
  Created by IntelliJ IDEA.
  User: Pro
  Date: 09.03.2020
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/users" method="post">
    <input required type="text" name="name" placeholder="Имя">
    <input required type="text" name="age" placeholder="Возраст">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>