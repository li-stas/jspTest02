<%--
  Created by IntelliJ IDEA.
  User: Pro
  Date: 09.03.2020
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список подразделений</title>
</head>
<body>
<table border="2">
    <tr>
        <td>deptno</td>
        <td>Название</td>
        <td>Местонахождение</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${dept}" var = "dept">
        <tr>
            <td>${dept.getDeptno()}</td>
            <td>${dept.getDname()}</td>
            <td>${dept.getLoc()}</td>
            <td>
                <form action = "updateDept.jsp" method="post">
                    <input type="hidden" name="deptno" value="${dept.getDeptno()}">
                    <input type="hidden" name="dname" value="${dept.getDname()}">
                    <input type="hidden" name="loc" value="${dept.getLoc()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteDept.jsp" method="post">
                    <input type="hidden" name="deptno" value="${dept.getDeptno()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addDept.jsp">
    <input type="submit" value="Добавить новый отдел">
</form>
</body>
</html>