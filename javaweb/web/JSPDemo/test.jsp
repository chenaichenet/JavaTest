<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/26
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP测试页面</title>
</head>
<body>
<%--    This is JSP page.<br>--%>

    <%--1、三种脚本模式--%>
<%--    <% int a=10; %>//局部变量--%>
<%--    <% out.println(a++);%><br/>--%>

<%--    <%=a%><br/>--%>

<%--    <%!--%>
<%--        int a=100;  //成员变量，没有销毁--%>
<%--        public void fun(){--%>
<%--            System.out.println(a);--%>
<%--        }--%>
<%--    %>--%>
<%--    <% out.println(this.a++);// fun();%>--%>

    <%--2、表--%>
    <table border="1" align="center" width="60%">
        <tr>
            <td align="center">姓名</td>
            <td align="center">年龄</td>
        </tr>
        <%
            for (int i=0;i<5;i++){
        %>
            <tr>
                <th>张三</th>
                <th>20</th>
            </tr>
        <%
            }
        %>
        <tr>
            <td>李四</td>
            <td>30</td>
        </tr>
    </table>

</body>
</html>
      