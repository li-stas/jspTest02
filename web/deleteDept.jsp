<%--
  Created by IntelliJ IDEA.
  User: Pro
  Date: 09.03.2020
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить подразделение</title>
</head>
<body>

Вы действительно хотите удалить подразделение ${param.deptno}?

&lform action="/users/${param.deptno}" method="post">
<input type="hidden" name="deptno" value="${param.deptno}">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Удалить">
</form>

</body>
</html>