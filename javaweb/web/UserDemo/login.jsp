<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/25
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
        function change() {
            /*1.得到img元素
            * 2.修改其src为原地址*/
            var imgEle=document.getElementById("img");
            imgEle.src="../VerifyCode?a="+new Date().getTime();
        }
    </script>
</head>
<body>
<h1>登录</h1>
<font color="red"> ${msg} </font><br/>
当前用户：<%=session.getAttribute("username")%><br/>
<form action="<c:url value="/Login"/>" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="verifyCode"/></td>
<%--            <td><img id="img" src="<c:url value="/VerifyCode"/>" onclick="change()"></td>--%>
            <td><img id="img" src="../VerifyCode" onclick="change()"></td>
            <td><a href="javascript:change">换一张</a></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
