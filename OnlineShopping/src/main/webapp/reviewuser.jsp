

<%@ page language="java" contentType="text/html; charsheet=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="objUser" class="org.fi.shopping.pojo.UserInfo"
		scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="objUser" />
	<table border='1'>
		<tr>
			<td>User Name</td>
			<td><jsp:getProperty property="UserName" name="objUser" /></td>
		</tr>

		<tr>
			<td>Password</td>
			<td><jsp:getProperty property="password" name="objUser" /></td>
		</tr>

		<tr>
			<td>name</td>
			<td><jsp:getProperty property="name" name="objUser" /></td>
		</tr>

		<tr>
			<td>Email</td>
			<td><jsp:getProperty property="email" name="objUser" /></td>
		</tr>
	</table>
	<a href='registeruser.jsp'>Register</a>&nbsp;&nbsp;&nbsp;
	<a href='newuser.html'>Cancel</a>

</body>
</html>