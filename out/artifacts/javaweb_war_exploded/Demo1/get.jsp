<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/24
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get</title>
</head>
<body>
<h1>获取session中的数据</h1>
<%
    out.print(session.getAttribute("session1"));
%>
</body>
</html>
