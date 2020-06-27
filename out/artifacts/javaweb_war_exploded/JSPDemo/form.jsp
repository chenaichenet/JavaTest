<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/26
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<%--3、表单--%>
<form action="<c:url value="/Add"/> " method="post">
    整数1：<input type="text" name="num1"/><br/>
    整数2：<input type="text" name="num2"/><br/>
    请选择一种运算:
    <select name="operation">
        <option value="plus">加法</option>
        <option value="reduce">减法</option>
        <option value="ride">乘法</option>
        <option value="except">除法</option>
    </select>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
