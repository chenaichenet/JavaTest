<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/16
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM</title>
</head>
<body>
    <a href="selectAll.do">查询所有</a>
    <hr/>

    <form action="selectWhere.do">
        按id查询：<input type="text" name="sid"><input type="submit" value="查询">
    </form>
    <hr/>

    <p>插入</p>
    <form action="insert.do" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" name="address"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="gender"></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><input type="text" name="phone"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="添加"></td>
            </tr>
        </table>
    </form>
    <hr/>
    <form action="update.do">
        按id修改：<input type="text" name="sid"><input type="submit" value="修改">
    </form>
    <hr/>
    <form action="delete.do">
        按id删除：<input type="text" name="sid"><input type="submit" value="删除">
    </form>
</body>
</html>
