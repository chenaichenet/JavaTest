<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/26
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
    Integer result= (Integer) request.getAttribute("result");
%>
<%=result%>

</body>
</html>
