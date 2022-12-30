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
 * Servlet implementation class AddCategory
 */
@WebServlet("/admin/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement preAddCategory;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			
			ServletContext appliction = getServletContext();
			
			connection =((Connection)appliction.getAttribute("golbalConnection"));
			
			System.out.println("preAddCategory :-" + connection);
			
			preAddCategory =connection.prepareStatement("insert into category_0013 values(?,?,?,?)");
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	public void destroy() {

		try {
			if(preAddCategory!=null) {
				preAddCategory.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			preAddCategory.clearParameters();
			
			String tmp = request.getParameter("categoryId");
			int categoryId = Integer.parseInt(tmp);
			String categoryName=request.getParameter("categoryName");
			String description=request.getParameter("description");
			String imageurl=request.getParameter("imageurl");
			
			preAddCategory.setInt(1, categoryId);
			preAddCategory.setString(2, categoryName);
			preAddCategory.setString(3, description);
			preAddCategory.setString(4, imageurl);
			
			preAddCategory.executeUpdate();
			
			response.sendRedirect("/AssignmentOnlineShoping/welcom.html");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
