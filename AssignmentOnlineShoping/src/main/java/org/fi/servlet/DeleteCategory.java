package org.fi.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement preDeleteCategory;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {

			ServletContext appliction = getServletContext();

			connection = ((Connection) appliction.getAttribute("golbalConnection"));

			System.out.println("ShowAllCategory :-" + connection);

			preDeleteCategory = connection.prepareStatement("delete from category_0013 where categoryName=?");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			if (preDeleteCategory != null) {
				preDeleteCategory.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String categoryName = request.getParameter("CategoryName");

			preDeleteCategory.setString(1, categoryName);
			preDeleteCategory.executeUpdate();

			response.sendRedirect("/AssignmentOnlineShoping/welcom.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
