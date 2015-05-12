<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>UserRegistrationPage</title>


</head>
<center><h1>New User Registration</h1></center>
<body>

<a href="https://www.facebook.com/dialog/oauth?client_id=575654462536938&redirect_uri=http://localhost:8080/IKONSOFT/UserRegistrationPage.jsp&scope=publish_actions&response_type=token">
	Register with your facebook account
</a>


<form action="UserRegistrationServlet"  method="post">
<table>

<tr>
<td><input id="accessToken" name="accesstoken" type="hidden" size="50"  /></td>
</tr>

<tr>
<td>First Name</td> 
<td><input type="text" name="firstname"  size="35" /></td> 
</tr>

<tr>
<td>Last Name</td> 
<td><input type="text" name="lastname"  size="35" /></td> 
</tr>

<tr>
 <td>Phone Number</td>
 <td><input type="text" name="phonenumber"  size="35" /></td>
</tr>

<tr></tr>
<tr>
<td><input type="submit" value="Register to my application" /></td> 
</tr>
<tr></tr>
<tr></tr>
</table>
</form>

<script type="text/javascript">
	var afterHashParameters = location.hash.toString();
	var accessTokenStartIndex = afterHashParameters.indexOf("=") + 1;
    var accessTokenEndIndex = afterHashParameters.indexOf("&");
    
    var accessToken = afterHashParameters.substring(accessTokenStartIndex,accessTokenEndIndex);
    
    var accessTokenHiddenInput = document.getElementById("accessToken");
    accessTokenHiddenInput.value = accessToken;
</script>

<form action="index.jsp">
<table>
<tr>
    <td><input type="submit" value="Go to home page"></td>
</tr>
</table>
</form>


</body>
</html>