<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: xxshetum
  Date: 3/23/2023
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

</head>
<body>
<form action="fetchAddress.jsp" method="post" name="fetch"><
<div>
<%
    try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "250601");
        PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
        preparedStatement.executeQuery();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from student_e");
        while(resultSet.next())
        {
%>
<%--<div class="container mt-3 rounded-4 p-3" style="box-shadow: 5px 5px 20px black;">--%>
<%--    <div class="row justify-content-center">--%>

<%--        <div class="col-lg-6 col-sm-12 align-self-center">--%>
<%--            <h1 class="text-info bg-info-subtle text-center rounded-5 mt-2">Student records</h1>--%>
<%--            <%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>--%>
<%--            <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--            <db:setDataSource var="studentDb" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="250601"/>--%>
<%--            <db:query var="profiles" sql="select * from student_e" dataSource="${studentDb}"/>--%>
<%--            <div class="table-responsive">--%>
                <table  class="table table-hover table-dark" align="center" border="1" width="100" style="width: 50%">
                    <thead>
                    <tr><th colspan="5"><center>Student Details</center></th> </tr>
                    <tr>
                        <th>Reg_Number</th><th>Name</th>
                        <th>Age</th><th>Email</th><th>View Address</th>
                    </tr>
                    </thead>
                    <tbody>
<%--                    <core:forEach var="student" items="${profiles.rows}">--%>
                        <tr>
                            <td><%=resultSet.getInt(1) %></td><td><%=resultSet.getString(2) %></td>
                            <td><%=resultSet.getInt(3) %></td><td><%=resultSet.getString(4) %></td>

                            <td>
                                <a href="fetchAddress.jsp?id=<%=resultSet.getInt(1)%>" class="btn btn-outline-warning">
                                    <i class="bi bi-house-fill"></i>
                                </a>
                            </td>

                        </tr>
<%--                    </core:forEach>--%>
                    </tbody>
                </table>

<%
    }
    }catch (Exception e)
    {
        e.printStackTrace();
    }
%>
<%--    </div>--%>
<%--</div>--%>
<%--    </div>--%>
<%--</div>--%>
</div>
</form>
</body>
</html>

