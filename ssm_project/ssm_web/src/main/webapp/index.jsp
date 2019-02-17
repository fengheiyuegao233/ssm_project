<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/16 0016
  Time: 下午 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<jsp:forward page="/WEB-INF/pages/main.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/product/findAll"><h1>点此查询所有数据</h1></a>
</body>
</html>
