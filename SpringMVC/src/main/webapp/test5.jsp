<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/18
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转发和重定向</title>
</head>
<body>
    <p>当处理器方法返回ModelAndView实现forward</p>
    <form action="doforward.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交请求">
    </form>
    <hr/>
    <p>当处理器方法返回ModelAndView实现redirect</p>
    <form action="doredirect.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交请求">
    </form>
    <hr/>
</body>
</html>
