<%--
  Created by IntelliJ IDEA.
  User: xxshetum
  Date: 3/27/2023
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> Login Page </title>
    <style>
        Body {
            font-family: Calibri, Helvetica, sans-serif;
            background-color: grey;
        }
        button {
            background-color: #4CAF50;
            width: 100%;
            color: orange;
            padding: 15px;
            margin: 10px 0px;
            border: none;
            cursor: pointer;
        }
        form {
            border: 3px solid #f1f1f1;
        }
        input[type=text], input[type=password] {
            width: 100%;
            margin: 8px 0;
            padding: 12px 20px;
            display: inline-block;
            border: 2px solid green;
            box-sizing: border-box;
        }

        .container {
            padding: 25px;
            background-color: darkgrey;
        }
    </style>
</head>
<body>
<center> <h1> Student Login</h1> </center>
<form action="validate.jsp" method="post">
    <div class="container">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" name="username">
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password">
        <button type="submit" class="container" style="background-color: darkcyan; border-color: black">Login</button>
    </div>
</form>
</body>
</html>
