<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/16
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理器方法的返回值</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
                alert("button click");
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String——表示视图名称</p>
    <form action="retrunString-view.do" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <hr/>
    <button id="btn">发起ajax请求</button>
</body>
</html>
