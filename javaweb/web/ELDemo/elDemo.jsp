<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/29
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导包--%>
<%@page import="com.jsp_demo.java.*" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    Address address=new Address();
    address.setCity("长沙");
    address.setStreet("五一街");

    Employee employee=new Employee();
    employee.setName("张三");
    employee.setSalary(12345);
    employee.setAddress(address);

    request.setAttribute("emp",employee);
%>
<h3>使用EL表达式获取request域中的emp</h3><br/>
姓名：${emp.name}<br/>
工资：${emp.salary}<br/>
城市：${emp.address.city}<br/>
<%--相当于emp.getAddress().getStreet()--%>
街道：${requestScope.emp.address.street}<br/>
${emp.test}<br/>
</body>
</html>
