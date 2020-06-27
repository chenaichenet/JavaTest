<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/25
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>用户界面</h1>
当前用户：<%=session.getAttribute("username")%><br/>
<a href="<c:url value="/UserDemo/welcom.jsp"/>">游客入口</a><br>
<a href="<c:url value="/UserDemo/user/user.jsp"/>">用户入口</a><br>
<a href="<c:url value="/UserDemo/admin/admin.jsp"/>">管理员入口</a><br>
</body>
</html>
