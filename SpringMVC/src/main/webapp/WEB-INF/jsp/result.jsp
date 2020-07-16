<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/16
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询所有——显示结果</title>
</head>
<body>
<table align="center" width="60%" border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>地址</th>
        <th>性别</th>
        <th>手机号</th>
    </tr>

    <c:forEach items="${requestScope.list}" var="classmate">
        <tr>
            <td>${classmate.id}</td>
            <td>${classmate.name}</td>
            <td>${classmate.age}</td>
            <td>${classmate.address}</td>
            <td>${classmate.gender}</td>
            <td>${classmate.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
