<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/25
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>登录</h1>
${msg}
<form action="<c:url value="/Login"/>" method="post">
    用户名：<input type="text" name="username"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
