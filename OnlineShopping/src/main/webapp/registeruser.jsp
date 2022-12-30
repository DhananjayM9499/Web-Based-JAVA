<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="objUser" type ="org.fi.shopping.pojo.UserInfo" scope="session"/>
<%
Connection connection = (Connection)application.getAttribute("globalConnection");
try(PreparedStatement psNewUser = connection.prepareStatement("insert into users_0018 values(?,?,?,?,'Pune')");
		)
{
psNewUser.setString(1,objUser.getUserName());
psNewUser.setString(2,objUser.getPassword());
psNewUser.setString(3,objUser.getName());
psNewUser.setString(4,objUser.getEmail());
psNewUser.executeUpdate();
}
%>
<font color='green'>you have been registered. </font>
</body>
</html>