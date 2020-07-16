<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/1
  Time: 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Show</title>
<%--    <%--%>
<%--        List<Person> list=PersonDao.selectAll();--%>
<%--    %>--%>
</head>
<body>
<table align="center" width="60%" border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>地址</th>
    </tr>

    <c:forEach items="${requestScope.list}" var="person">
        <tr>
            <td>${person.p_id}</td>
            <td>${person.p_name}</td>
            <td>${person.p_age}</td>
            <td>${person.p_address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
