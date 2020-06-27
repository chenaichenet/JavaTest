<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/27
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session方法</title>
</head>
<body>
直接打印Session：
<%
    out.println(session);
%><br/>
Session最大不活动时间：
<%
    out.println(session.getMaxInactiveInterval());
%><br/>
Session是否为新：
<%
    out.println(session.isNew());
%><br/>
SessionID：
<%
    out.println(session.getId());
%><br/>
<%
    out.println(request.getSession());
%>
<%
    //    session.invalidate();//session失效
%>
</body>
</html>
