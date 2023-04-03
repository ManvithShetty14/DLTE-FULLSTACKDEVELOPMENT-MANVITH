<html>
<head>
    <title>Select the Option</title>
    <style>
        .container {
            background-color: darkgrey;
        }
        Body {
            font-family: Calibri, Helvetica, sans-serif;
            background-color: grey;
        }
    </style>

</head>
<body>
<div class="container">

<%
		//HERE WE GETTING THE ATTRIBUTE DECLARED IN VALIDATE.JSP AND CHECKING IF IT IS NULL, THE USER WILL BE REDIRECTED TO LOGIN PAGE
				String uid = (String)session.getAttribute("user");
				if (uid == null)
				{
		%><!-- NOT A VALID USER, IF THE USER TRIES TO EXECUTE LOGGED IN PAGE DIRECTLY, ACCESS IS RESTRICTED -->
<jsp:forward page="login.jsp"/>
<%
}
else
{//IF THE VALUE IN SESSION IS NOT NULL THEN THE IS USER IS VALID
    out.println(" <h1>You have successfully created the Logged of User" +uid+"</h1>");
%>
<a href="InsertRecord.jsp">
    <h2 class="bg-color-info">Insert Student Record</h2></a>
<a href="fetch.jsp">
    <h2 class="bg-color-info">View Student record</h2></a>
<%}
%>
</div>

</body>
</html>
