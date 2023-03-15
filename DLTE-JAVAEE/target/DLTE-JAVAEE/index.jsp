<html>
<body>
<h2>Hello World!</h2>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource var="hai" driver="oracle.jdbc.driver.OracleDriver" url="jbc:oracle:thin:@localhost:1521:xe" user="system" password="250601" />
<sql:query var="qry" dataSource="${hai}" sql="select * from credit_card" />
</body>
</html>
