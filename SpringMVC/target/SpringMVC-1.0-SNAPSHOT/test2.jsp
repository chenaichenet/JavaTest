<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/15
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--相对地址与绝对地址，使用base标签--%>
<%--<%--%>
<%--    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";--%>
<%--%>--%>
<html>
<head>
    <title>@RequestMapping的详细使用</title>e
<%--    <bast href="<%=basePath%>"/>--%>
</head>
<body>
    <p>第二个springmvc项目</p>
    <p><a href="test/some.do">发起test/some.do的GET请求</a></p>
    <p><a href="test/first.do">发起test/first.do的GET请求</a></p>
    <p><a href="test/other.do">发起test/other.do的POST请求</a></p>

    <form action="test/other.do" method="post">
        <input type="submit" value="发起test/other.do的POST请求">
    </form>
    <hr/>
    <p>相对地址与绝对地址</p>
    <p><a href="test/some.do">发起test/some.do的GET请求</a></p>
    <p><a href="/test/some.do">发起/test/some.do的GET请求</a></p>
    <p><a href="/SpringMVC/some.do">发起/SpringMVC/some.do的GET请求</a></p>
    <p><a href="${pageContext.request.contextPath}/some.do">发起El表达式：pageContext.request.contextPath/some.do的GET请求</a></p>
    <p><a href="test/some.do">测试base</a></p>
</body>
</html>
