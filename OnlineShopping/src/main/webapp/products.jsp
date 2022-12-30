<%@page import="javax.crypto.spec.PSource.PSpecified"%>
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
		<th>Price</th>
		<th>Image</th>
	</tr>
	<%
	Connection connection = (Connection) application.getAttribute("globalConnection");
	try (PreparedStatement psProduct = connection.prepareStatement("select * from product_0018 where categoryId=?");) {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		psProduct.setInt(1, categoryId);
		ResultSet result = psProduct.executeQuery();
		while (result.next()) {
	%>
	<tr>
		<td><%=result.getString("productName")%></td>
		<td><%=result.getString("productDescription")%></td>
		<td><%=result.getString("productPrice")%></td>
		<td><img src='Images/<%=result.getString("productImageUrl")%>'
			height='120px' width='120px' /></td>
		<td><a
			href='AddCart?categoryId=<%=result.getInt("categoryId")%>&productId=<%=result.getInt("productId")%>&productPrice=<%=result.getFloat("productPrice")%>'
			>Add to Cart</a></td>
	</tr>
	<%
	}
	}
	%>



</table>
</body>
</html>