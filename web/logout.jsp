<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2019/9/28
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%
        session.invalidate();
    %>
    <jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>
