<%--
  Created by IntelliJ IDEA.
  User: xxshetum
  Date: 4/2/2023
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Validate</title>
</head>
<body>
<form action="index.jsp" method="post">
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if(username.equals("manvith") && password.equals("qwerty")){
        session.setAttribute("user", username);//THIS IS HOW WE DECLARE THE USER IN A SESSION
        response.sendRedirect("index.jsp"); //AND WE REDIRECTED TO LOGIN PAGE

    }else{

        response.sendRedirect("login.jsp");
    }
%>
</form>
</body>
</html>
