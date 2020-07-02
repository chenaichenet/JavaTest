<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/2
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AJAX第五例：省市联动</title>
    <script type="text/javascript">
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
        /*文档加载完毕时发送请求，得到所有省份名称，显示在省份选择中
        * 在选择新的省份时发送请求，参数为省名称，得到xml文档，即<province>元素
        * 解析xml文档，得到所有<city>，再得到所有<city>元素的内容，生成<option>再插入回去*/
        window.onload=function () {
            var xmlHttp=createXMLHttpRequest();
            xmlHttp.open("GET","<c:url value='/Province'/>",true);
            xmlHttp.send(null);
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4 && xmlHttp.status==200){
                    //获取服务器端的响应
                    var text=xmlHttp.responseText;
                    //使用逗号分割，得到数组
                    var arr=text.split(",");
                    //循环遍历每个省份名称，每个名称生成一个option对象，添加到<select>中
                    for (var i=0;i<arr.length;i++){
                        var op=document.createElement("option");    //创建一个指定名称的元素
                        op.value=arr[i];    //设置op的实际值为当前的省份名称
                        var textNode=document.createTextNode(arr[i]);   //创建文本节点
                        op.appendChild(textNode);   //把文本字节的添加到op元素中，指定显示值

                        document.getElementById("P").appendChild(op);
                    }
                }
            };
        };
    </script>
</head>
<body>

<select name="province" id="P">
    <option>===请选择省份===</option>
</select>
<hr/>
<select name="city">
    <option>===请选择城市===</option>
</select>

</body>
</html>
