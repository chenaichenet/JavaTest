<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/2
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AJAX第三例：用户已被注册</title>
    <script type="text/javascript">
        /*创建异步对象*/
        function createXMLHttpRequest(){
            try {
                return new XMLHttpRequest();
            }catch (e) {
                try {
                    return ActiveXObject("Msxml2.XMLHTTP");
                }catch (e) {
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP")
                    }catch (e) {
                        alert("没有对应浏览器");
                        throw e;
                    }
                }
            }
        }

        window.onload=function () {
            //获取文本框，给它的失去焦点事件注册监听
            var userEle=document.getElementById("userText");
            userEle.onblur=function () {
                var xmlHttp=createXMLHttpRequest();
                xmlHttp.open("post","<c:url value='/ValidateUsername'/>",true);
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xmlHttp.send("username="+userEle.value);
                xmlHttp.onreadystatechange=function () {
                    if (xmlHttp.readyState==4 && xmlHttp.status==200){
                        //xmlHttp状态为4（服务响应结束），以及服务器响应的状态码为200（响应成功）
                        //获取服务器响应结果
                        var text=xmlHttp.responseText;
                        var span=document.getElementById("errorSpan");
                        if (text=="1"){
                            span.innerHTML="用户名已经被注册";
                        }else {
                            span.innerHTML="";
                        }
                    }
                };
            };
        };

    </script>
</head>
<body>
<h3>演示用户名是否被注册</h3>
<form action="" method="post">
    用户名：<input type="text" name="username" id="userText"/><span id="errorSpan"></span><br/>
    密  码：<input type="text" name="password"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
