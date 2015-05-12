<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>AdminControlPage</title>
</head>
<center><h1>Current Registered Users</h1></center>
<body>

<form action="SendServlet"  method="get">
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/ikonsoftdb"
     user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="result">
   SELECT * from users;
</sql:query>

<table border="1" width="50%">
<tr>

<th>First Name</th>
<th>Last Name</th>
<th>Phone</th>
<th></th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.userFirstName}"/></td>
<td><c:out value="${row.userLastName}"/></td>
<td><c:out value="${row.userPhone}"/></td>
<td><input type="checkbox" name="checkedusers" value="${row.userToken}"> </td>
</tr>
</c:forEach>
</table>
<br>
<input type="text" name="admin_message" size="50" />
<input type="submit" value="Post Message" />

</form>

</body>
</html>