<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/6/29
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入EL的JSTL（标准标签库）--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--导入自定义函数库--%>
<%@ taglib prefix="it" uri="/WEB-INF/Tlds/itcast.tld" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>EL函数库</title>
</head>
<body>
<h1>JSTL提供的EL函数库</h1>
<%
    String[] strs={"a","b","c"};
    List list=new ArrayList();
    list.add("a");
    pageContext.setAttribute("arr",strs);
    pageContext.setAttribute("list",list);
%>
数组长度：${fn:length(arr)};<br/>
集合长度：${fn:length(list)};<br/>
Hello全部大写：${fn:toUpperCase("Hello")}<br/>
Hello全部小写：${fn:toLowerCase("Hello")}<br/>
abc中是否包含a：${fn:contains("abc","a")}<br/>
忽略大小写abc是否包含Ab：${fn:containsIgnoreCase("abc","Ab")}<br/>
数组中是否包含a：${fn:contains(arr,"a")}<br/>
Hello.java是否以Hello为前缀：${fn:startsWith("Hello.java","Hello")}<br/>
Hello.java是否以java为后缀：${fn:endsWith("Hello.java","Hello")}<br/>
略
<hr/>
<h3>自定义的函数库</h3>
自定义的函数：${it:fun()}<br/>
</body>
</html>
