<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/18
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示结果</title>
</head>
<body>
    <h2>当处理器方法返回ModelAndView实现redirect</h2>
    <h3>msg数据：${msg}</h3>
    <h3>fun数据：${fun}</h3>
    <h3>param.msg数据：${param.msg}</h3>
    <h3>param.fun数据：${param.fun}</h3>
    <h3>取参数数据：<%=request.getParameter("age")%></h3>
    <h3>取参数数据：<%=request.getParameter("fun")%></h3>
</body>
</html>
