<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/18
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--相对地址与绝对地址，使用base标签--%>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>查询——Ajax</title>
    <base href="<%=basePath%>"/>
    <%--这个标签必须有头有尾--%>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //当前页面加载dom对象后，执行loadData()，即不用点击按钮
            loadData();
            //单击按钮显示数据
            $("#btn").click(function () {
                loadData();
            })
        })
        function loadData() {
            $.ajax({
                url:"queryClassmate.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    // alert("data"+data);

                    //清除旧数据
                    $("#info").html("");
                    //增加新数据
                    $.each(data,function (i,n) {
                        $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("<td>"+n.address+"</td>")
                            .append("<td>"+n.gender+"</td>")
                            .append("<td>"+n.phone+"</td>")
                            .append("</tr>")
                    })
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <table>
            <thead>
            <tr>
                <td>ID</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>地址</td>
                <td>性别</td>
                <td>手机号</td>
            </tr>
            </thead>
            <tbody id="info">

            </tbody>
        </table>
        <input type="button" id="btn" value="查询数据">
    </div>
</body>
</html>
