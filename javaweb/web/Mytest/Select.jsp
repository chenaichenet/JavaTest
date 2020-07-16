<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/1
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select</title>
</head>
<body>
<form action="<c:url value="/SelectWhere"/>">
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td><input type="submit" value="按ID查询"/></td>
        </tr>
    </table>
</form>
<a href="<c:url value="/SelectAll"/>">查询所有</a>
</body>
</html>
