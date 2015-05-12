<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>AdminLoginPage</title>
</head>
<center> <h2>Admin Login Page</h2> </center>
<body>
<form action="AdminLoginServlet" method="post"> 
<table>
<tr>
<td>Username</td> 
<td><input type="text" name="adminusername"  /></td> 
</tr>
<tr>
 <td>Password</td>
 <td><input type="password" name="adminpassword"  /></td>
</tr>
<tr>
<td><input type="submit" value="Login" /></td> 
</tr>
</table>
</form>

<form action="index.jsp">
<table>
<tr>
    <td><input type="submit" value="Back"></td>
</tr>
</table>
</form>
</body>
</html>