<%@ page import="com.mysql.cj.protocol.Resultset"%>
<%@ page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
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
	Welcome
	<b><%=session.getAttribute("userName")%></b>
	<br />
	<table border='1'>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		<%
Connection connection =(Connection)application.getAttribute("globalConnection");
try(PreparedStatement psCategory = connection.prepareStatement("select * from category_0018");
		ResultSet result = psCategory.executeQuery())
{
while(result.next())	
{
%>
		<tr>
			<td><a
				href='products.jsp?categoryId=<%=result.getInt("categoryId")%>'>
					<%=result.getString("categoryName") %>
			</a></td> 
			
			<td><%=result.getString("CategoryDescription")%></td>
			
			<td><img src='Images/<%=result.getString("categoryImageUrl") %>' height = '120px' width= '120px'/></td>
			</tr>
			<% 
			} } %>
	</table>
</body>
</html>