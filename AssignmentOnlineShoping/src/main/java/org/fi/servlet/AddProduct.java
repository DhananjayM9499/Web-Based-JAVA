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
 * Servlet implementation class AddProduct
 */
@WebServlet("/admin/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement preAddProduct;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			
			ServletContext appliction = getServletContext();
			
			connection =((Connection)appliction.getAttribute("golbalConnection"));
			
			System.out.println("preAddCategory :-" + connection);
			
			preAddProduct =connection.prepareStatement("insert into product_0013 values(?,?,?,?,?)");
		
			
			
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
			if(preAddProduct!=null) {
				preAddProduct.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			preAddProduct.clearParameters();
			
			String tmp = request.getParameter("productID");
			int productID = Integer.parseInt(tmp);
			String productName=request.getParameter("productName");
			String productDescription=request.getParameter("productDescription");
			String productImgUrl=request.getParameter("productImgUrl");
			String productPrice=request.getParameter("productPrice");
			
			preAddProduct.setInt(1, productID);
			preAddProduct.setString(2, productName);
			preAddProduct.setString(3, productDescription);
			preAddProduct.setString(4, productImgUrl);
			preAddProduct.setString(5, productPrice);
			
			preAddProduct.executeUpdate();
			
			response.sendRedirect("/AssignmentOnlineShoping/welcom.html");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
