<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/22
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$<br/>
  <%
    out.println(session);
  %><br/>
  <%
    out.println(session.getAttribute("JSESSIONID"));
  %><br/>
  <%
    out.println(session.getClass().getName());
  %><br/>
  <%
    session.setAttribute("aaa","AAA");
  %>
  <%
    out.println(session.getAttribute("aaa"));
  %>
  </body>
</html>
