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
    <title>Добавить новое подразделение</title>
</head>
<body>
<form action = "/depts" method="post">
    <input required type="text" name="dname" placeholder="Название">
    <input required type="text" name="loc" placeholder="Местонахождение">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>