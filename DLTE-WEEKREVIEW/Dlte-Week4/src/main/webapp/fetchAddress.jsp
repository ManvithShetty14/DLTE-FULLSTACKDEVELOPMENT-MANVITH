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
<div clas="row">
    <div class="col">
<%
//    String rec_reg=request.getParameter("student_reg");
//    Integer stud_reg=Integer.parseInt(rec_reg);
    try{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "250601");
        PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
        preparedStatement.executeQuery();
        preparedStatement = connection.prepareStatement("SELECT address_e.address_id,address_e.door_no,address_e.street,address_e.city,address_e.pincode FROM address_e , address_mapper WHERE address_e.address_id=address_mapper.address_id and address_e.address_type='Communication' and address_mapper.reg_no=?");
        preparedStatement.setInt(1,Integer.parseInt(request.getParameter("id")));
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
%>

<table  class="table table-hover table-dark" align="center" border="1" width="40" style="width: 50%">
    <thead>
    <tr><th colspan="5">Communication Address</th> </tr>
    <tr>
        <th>Address_id</th><th>Door_no</th>
        <th>Street</th><th>City</th><th>Pincode</th>
    </tr>
    </thead>
    <tbody>
    <%--                    <core:forEach var="student" items="${profiles.rows}">--%>
    <tr>
        <td><%=resultSet.getInt(1) %></td><td><%=resultSet.getInt(2) %></td>
        <td><%=resultSet.getString(3) %></td><td><%=resultSet.getString(4) %></td><td><%=resultSet.getInt(5) %></td>

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
    </div>

    <div class="col">
        <%
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "250601");
                PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=MANVITH");
                preparedStatement.executeQuery();
                preparedStatement = connection.prepareStatement("SELECT address_e.address_id,address_e.door_no,address_e.street,address_e.city,address_e.pincode FROM address_e , address_mapper WHERE address_e.address_id=address_mapper.address_id and address_e.address_type='Permanent' and address_mapper.reg_no=?");
                preparedStatement.setInt(1,Integer.parseInt(request.getParameter("id")));
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next())
                {
        %>

        <table  class="table table-hover table-dark" align="center" border="1" width="40" style="width: 50%">
            <thead>
            <tr><th colspan="5">Permanent Address</th> </tr>
            <tr>
                <th>Address_id</th><th>Door_no</th>
                <th>Street</th><th>City</th><th>Pincode</th>
            </tr>
            </thead>
            <tbody>
            <%--                    <core:forEach var="student" items="${profiles.rows}">--%>
            <tr>
                <td><%=resultSet.getInt(1) %></td><td><%=resultSet.getInt(2) %></td>
                <td><%=resultSet.getString(3) %></td><td><%=resultSet.getString(4) %></td><td><%=resultSet.getInt(5) %></td>

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
    </div>
</div>

<%--    </div>--%>
<%--</div>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>
