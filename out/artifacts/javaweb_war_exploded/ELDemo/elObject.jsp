<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/29
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL11个内置对象</title>
</head>
<body>
<%--map.key这是el的语法，map['key']也可以操作map--%>
<%--使用方法：http://localhost:8080/javaweb_war_exploded/ELDemo/elObjectDemo?username=123--%>
获取参数username：${param.username}<br/>
<%--使用方法：http://localhost:8080/javaweb_war_exploded/ELDemo/elObjectDemo?username=123&hobby=abc&hobby=qwe--%>
获取参数hobby：${paramValues.hobby[0]}<br/>
获取参数hobby：${paramValues.hobby[1]}<br/>
获取请求头：${header['User-Agent']}<br/>
获取context-param：${initParam.name}<br/>
<hr/>
<%--获取Cookie--%>
<%
    response.addCookie(new Cookie("cook","12345Cookie"));
%>
Cookie名称：${cookie.cook.name}，Cookie对象：${cookie.cook.value}<br/>
JSESSIONID值：${cookie.JSESSIONID.value}<br/>
当前项目名：${pageContext.request.contextPath}<br/>
<hr/>
不使用cookie获取JSESSIONID的值：${pageContext.session.id}
<hr/>
使用pageContext的pageContext.request.contextPath实现点击跳转<br/>
<a href="${pageContext.request.contextPath}/index.html">点击这里</a>
<form action="${pageContext.request.contextPath}/index.jsp">
    <input type="submit" value="按钮"/>
</form>
</body>
</html>
