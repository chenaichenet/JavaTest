<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/2
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ajax第一例：发送GET请求</title>
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
            var btn=document.getElementById("btn");
            btn.onclick=function () {
              /*ajax四步操作，得到服务器的响应，返回响应结果到h1中*/
                //得到异步对象
                var xmlHttp=createXMLHttpRequest();
                /*请求方式：GET/POST。
                请求的URL：指定服务器端资源。
                请求是否为异步：true表示发送异步请求，否则同步请求*/
                xmlHttp.open("GET","<c:url value='/AJAXDemo'/>",true);
                xmlHttp.send(null); //get请求没有请求体，但也有给出null
                xmlHttp.onreadystatechange=function () {
                    //xmlHttp状态发送变化时
                    if (xmlHttp.readyState==4 && xmlHttp.status==200){
                        //xmlHttp状态为4（服务响应结束），以及服务器响应的状态码为200（响应成功）
                        //获取服务器响应结果
                        var text=xmlHttp.responseText;
                        var h1=document.getElementById("h1");
                        h1.innerHTML=text;
                    }
                };
            };
        };
    </script>
</head>
<body>

<button id="btn">点击</button>
<h1 id="h1"></h1>

</body>
</html>
