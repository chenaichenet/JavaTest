<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/21
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>文件上传</h3>
    <form action="fileupload.do" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br/>
        <input type="submit" value="上传">
    </form>
</body>
</html>
