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
 * Servlet implementation class Category
 */
@WebServlet(loadOnStartup = 1000, urlPatterns = { "/Category" })
public class Category extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement psAuthenticate;

	@Override
	public void destroy() {
		try {
			if (psAuthenticate != null)
				psAuthenticate.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			ServletContext application = getServletContext();

			connection = (Connection)application.getAttribute("globalConnection");
			System.out.println("Category : " + connection);
			psAuthenticate = connection.prepareStatement("select * from category_0018 ");

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
		try (ResultSet result = psAuthenticate.executeQuery()) {
			while (result.next()) {
				out.println("<tr>");
				out.println("<td><a href = 'Products?categoryId=" + result.getInt("categoryId") + "'>"
						+ result.getString("categoryName") + "</a></td>");
				out.println("<td>"+result.getString("categoryDescription")+"</td>");
				out.println("<td><img src = 'Images/"+result.getString("categoryImageUrl")+ "'height = '120px' width='120px'/></td>");
			out.println("</tr>");
			
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
