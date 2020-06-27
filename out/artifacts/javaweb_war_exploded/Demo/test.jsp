<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/23
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <form action="<c:url value="/Demo2"/>" method="post">
        <table align="center">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="pwd"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
