<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/15
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理方法的参数</title>
</head>
<body>
    <p>提交参数给Controller</p>
    <form action="receiveproperty.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <hr/>
    <p>请求参数名和处理器方法的形参名不一致</p>
    <form action="receiveparam.do" method="post">
        姓名：<input type="text" name="rname"><br/>
        年龄：<input type="text" name="rage">
        <input type="submit" value="提交参数">
    </form>
    <hr/>
    <p>使用Java对象接收请求参数</p>
    <form action="receiveobject.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
</body>
</html>
