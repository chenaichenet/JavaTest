<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/23
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h1 align="center">
    <%=request.getParameter("name") %>,登录成功<br>
</h1>
    <a href="../index.jsp">【退出】</a>
</body>
</html>
