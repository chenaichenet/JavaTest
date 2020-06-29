<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/25
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游客页面</title>
</head>
<body>
<h1>游客界面</h1>
当前用户：<%=session.getAttribute("username")%><br/>
<a href="<c:url value="/UserDemo/welcom.jsp"/>">游客入口</a><br>
<a href="<c:url value="/UserDemo/user/user.jsp"/>">用户入口</a><br>
<a href="<c:url value="/UserDemo/admin/admin.jsp"/>">管理员入口</a><br>

<%--自己写的，问题在于转发的情况下，路径缺失--%>
<%--<a href="welcom.jsp">游客入口</a>--%>
<%--<a href="user/user.jsp">用户入口</a>--%>
<%--<a href="admin/admin.jsp">管理员入口</a>--%>
<%--还是自己写的--%>
<%--<a href="/UserDemo/welcom.jsp">游客入口</a>--%>
<%--<a href="/UserDemo/user/user.jsp">用户入口</a>--%>
<%--<a href="/UserDemo/admin/admin.jsp">管理员入口</a>--%>
</body>
</html>
