<%--
  Created by IntelliJ IDEA.
  User: 嘉平十七
  Date: 2020/7/1
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="it" uri="/WEB-INF/Tlds/mytag.tld"%>
<html>
<head>
    <title>自定义标签</title>
</head>
<body>

<h1><it:tag1/></h1>
<hr/>

<h1><it:tag2/></h1>
<hr/>

<%--xxx存在，执行--%>
<it:tag4 test="${empty param.zzz}">
    <it:tag1/><br/>
    这里看看<br/>
</it:tag4><br/>

<%
    request.setAttribute("xxx","TagXXX");
%>
<it:tag3>${xxx}<br/></it:tag3>
<%--这句看不见--%>
<it:tag3>带标签体的自定义标签<br/></it:tag3>
<hr/>

<%--这里是tag3定义的不再执行--%>
<h1>这是你看不到的</h1>

</body>
</html>
