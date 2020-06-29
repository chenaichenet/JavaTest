<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/28
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jsp指令</title>
</head>
<body>
<h1>lo.jsp</h1>
<%
    /*include指令*/
//    out.println("姓名："+name+"、年龄："+age);
    /*param动作标签*/
    String username=request.getParameter("qwe");
    String userage=request.getParameter("asd");
    out.println(username+","+userage);
%>
</body>
</html>
