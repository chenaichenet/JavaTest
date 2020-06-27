<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/27
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCookie</title>
</head>
<body>
<h1>保存Cookie</h1>
<%
    Cookie cookie1=new Cookie("aaa","AAA");
    Cookie cookie2=new Cookie("bbb","BBB");
    Cookie cookie3=new Cookie("ccc","CCC");

    cookie1.setMaxAge(60);
    cookie2.setPath("/CookieDemo");

    response.addCookie(cookie1);
    response.addCookie(cookie2);
    response.addCookie(cookie3);
%>
</body>
</html>
