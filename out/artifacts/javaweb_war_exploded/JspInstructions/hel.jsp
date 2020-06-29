<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/28
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jsp指令</title>
</head>
<body>
<h1>hel.jsp</h1>
<%
    String name="张三";
    int age=20;
%>
<%--静态包含：include指令--%>
<%--静态包含只生成一个class，所以lo.jsp不可以访问--%>
<%--<%@include file="lo.jsp"%>--%>

<%--动态包含：include动作标签--%>
<%--动态包含会生成两个serlvet，两个class，所以lo.jsp也可以访问。--%>
<%--<jsp:include page="lo.jsp"/>--%>

<%--转发：forword动作标签--%>
<%--转发，就不会在显示hel.jsp中定义的<h1>标签了，forword动作标签表示了所有显示都交由转发的地址--%>
<jsp:forward page="lo.jsp">
    <%--param动作标签--%>
    <jsp:param name="qwe" value="zhangsan"/>
    <jsp:param name="asd" value="20"/>
</jsp:forward>
</body>
</html>
