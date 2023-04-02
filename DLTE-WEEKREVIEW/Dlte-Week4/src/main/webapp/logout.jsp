<%--
  Created by IntelliJ IDEA.
  User: xxshetum
  Date: 3/28/2023
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<%
session.invalidate();
response.sendRedirect("login.jsp");
%>

</body>
</html>
