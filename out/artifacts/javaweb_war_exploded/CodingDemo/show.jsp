<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/25
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>字符编码</title>
</head>
<body>
<%--doGet方法--%>
<a href="<c:url value="/Coding?username=张三"/>">点击这里</a>
<%--doPost方法--%>
<form action="<c:url value="/Coding"/>" method="post">
    用户名：<input type="text" name="username" value="李四">
    <input type="submit" value="提交"/>
</form>
</body>
</html>
