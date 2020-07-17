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
                // alert("button click");
                /*ajax函数*/
                $.ajax({
                    /*参数*/
                    //url:"returnVoid-ajax",//返回void
                    //url:"returnParamJson",//返回单个对象
                    // url:"returnParamJsonArray",//返回List集合
                    url:"resutnStringData",//返回String表示数据
                    data:{
                        name:"张三",
                        age:30
                    },
                    type:"post",
                    //数据格式
                    //加也行，不加也行，因为在Controller中已经标明了类型：response.setContentType("application/json;charset=utf-8");
                    //jquery会尝试把数据转换成json
                    dataType:"json",
                    success:function (resp) {
                        //resp从服务器端返回的是json格式的字符串{"name":"张三","age":20}
                        //jquery会把字符串转为json对象，赋值给resp形参
                        // alert(resp);

                        /*返回void和单个对象时*/
                        //alert(resp.name+" "+resp.age)

                        /*返回List时*/
                        // $.each(resp,function (i,n) {    //n是对象
                        //     alert(n.name+" "+n.age)
                        // })

                        /*返回的String数据
                        * 此时需要把上面的dataTyupe="json"注释掉，或者改成dataType="text"
                        * 否则会出现解析json数据时出现错误*/
                        alert("返回的是文本数据："+resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>处理器方法返回String——表示视图名称</p>
    <form action="returnString-view" method="post">
        姓名：<input type="text" name="name"><br/>
        年龄：<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>
    <hr/>
    <button id="btn">发起ajax请求</button>
    <hr/>
    <img src="images/001.jpg" alt="图片">
</body>
</html>
