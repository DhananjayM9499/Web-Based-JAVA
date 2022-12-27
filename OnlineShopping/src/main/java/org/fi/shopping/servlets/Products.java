package org.fi.shopping.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement psProducts;

	@Override
	public void destroy() {
		try {
			if (psProducts != null)
				psProducts.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			ServletContext application = getServletContext();
			connection = (Connection)application.getAttribute("globalConnection");
			System.out.println("Products : " + connection);
			psProducts = connection.prepareStatement("select * from product_0018 where categoryId =?");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");
		try {
			String tmp = request.getParameter("categoryId");
			int categoryId = Integer.parseInt(tmp);
			psProducts.setInt(1, categoryId);
			try (ResultSet result = psProducts.executeQuery()) {
				while (result.next()) {
					out.println("<tr>");
					out.println("<td>" + result.getString("productName") + "</td>");
					out.println("<td>" + result.getString("productDescription") + "</td>");
					out.println("<td><img src = 'Images/" + result.getString("productImageUrl")
							+ "'height = '120px' width='120px'/></td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
