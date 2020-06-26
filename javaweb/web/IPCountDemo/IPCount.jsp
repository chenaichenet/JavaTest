<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/25
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>IPCount</title>
</head>
<body>
<h1 align="center">显示结果</h1>
<table align="center" width="60%" border="1">
    <tr>
        <th>IP</th>
        <th>次数</th>
    </tr>
    <%--entry表示一个键一个值--%>
    <c:forEach items="${applicationScope.map}" var="entry">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
