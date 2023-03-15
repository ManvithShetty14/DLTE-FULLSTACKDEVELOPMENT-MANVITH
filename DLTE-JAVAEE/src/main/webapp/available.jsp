<%@ page import="java.util.List" %>
<%@ page import="crud.oracle.Card" %>
<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 07-03-2023
  Time: 11:19 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <% List<KYC> objects=(List<KYC>)request.getAttribute("dbData"); %>--%>
<%
    List<Card> objects=(List<Card>)request.getAttribute("dbData");
    pageContext.setAttribute("profiles",objects,PageContext.APPLICATION_SCOPE);
%>
<table>
    <thead>
    <tr>
        <th>Card_Number</th><th>Card_Holder</th><th>Card_PIN</th>
        <th>Card_Expiry</th><th>Limit</th>
    </tr>
    </thead>
    <tbody>
    <% for(Card card:objects){ %>
    <tr>
        <td><%=card.getAcc_number()%></td>
        <td><%=card.getAcc_holder()%></td>
        <td><%=card.getPasscode()%></td>
        <td><%=card.getAcc_bal()%></td>
        <td><%=card.getAadhaar()%></td>
        <td><%=card.getPan()%></td>
        <td><%=card.getEmail()%></td>
        <td><%=card.getContact()%></td>
        <td><%=card.getAddress()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
<a href="view_profiles.jsp">View Profiles once again</a>
</body>
</html>
