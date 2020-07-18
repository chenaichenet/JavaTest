<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/19
  Time: 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拦截器演示——退出</title>
</head>
<body>
    退出系统
    <%
        session.removeAttribute("name");
    %>
</body>
</html>
