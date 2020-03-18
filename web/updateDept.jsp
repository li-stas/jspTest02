<%--
  Created by IntelliJ IDEA.
  User: Pro
  Date: 09.03.2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные подразделения</title>
</head>
<body>

Редактировать подразделения

<form action="/depts/${param.deptno}" method="post">
    <input type="hidden" name = "deptno" value="${param.deptno}">
    <input type="text" name="dname" value="${param.dname}" placeholder=${param.dname}>
    <input type="text" name="loc" value="${param.loc}" placeholder=${param.loc}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>