<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/27
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取Cookie</title>
</head>
<body>
<h1>获取Cookie</h1>
<%
    Cookie cookie=new Cookie("ccc","CCC");
    cookie.setMaxAge(0);
    response.addCookie(cookie);//删除同名Cookie，设置maxAge为0，随后还需要添加进去。

    Cookie[] cookies=request.getCookies();  //循环输出
    if (cookies!=null){
        for (Cookie c:cookies){
            out.print(c.getName()+"="+c.getValue()+"<br/>");
        }
    }
%>
</body>
</html>
