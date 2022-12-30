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
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement preDeleteProduct;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {

			ServletContext appliction = getServletContext();

			connection = ((Connection) appliction.getAttribute("golbalConnection"));

			System.out.println("ShowAllCategory :-" + connection);

			preDeleteProduct = connection.prepareStatement("delete from product_0013 where productName=?");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void destroy() {
		try {
			if (preDeleteProduct != null) {
				preDeleteProduct.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String productName = request.getParameter("ProductName");

			preDeleteProduct.setString(1, productName);
			preDeleteProduct.executeUpdate();

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
