<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/15
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>@RequestMapping的详细使用</title>
</head>
<body>
    <p>第二个springmvc项目</p>
    <p><a href="test/some.do">发起test/some.do的GET请求</a></p>
    <p><a href="test/first.do">发起test/first.do的GET请求</a></p>
    <p><a href="test/other.do">发起test/other.do的POST请求</a></p>

    <form action="test/other.do" method="post">
        <input type="submit" value="发起test/other.do的POST请求">
    </form>
</body>
</html>
