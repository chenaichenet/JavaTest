<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/18
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拦截器</title>
</head>
<body>
    <p>拦截器</p>
    <form action="doInterceptor.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
