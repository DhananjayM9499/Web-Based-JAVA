package org.fi.servlet;

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
 * Servlet implementation class ShowAllCategories
 */
@WebServlet("/admin/ShowCategories")
public class ShowAllCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection;
	PreparedStatement preShowAllCategory;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			
			ServletContext appliction = getServletContext();
			
			connection =((Connection)appliction.getAttribute("golbalConnection"));
			
			System.out.println("ShowAllCategory :-" + connection);
			
			preShowAllCategory = connection.prepareStatement("select * from category_0013 ");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 @Override
	public void destroy() {

			try {
				if(preShowAllCategory!=null) {
					preShowAllCategory.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>categoryId</th>");
		out.println("<th>categoryName</th>");
		out.println("<th>categoryDescription</th>");
		out.println("<th>categoryImageUrl</th>");
		out.println("</tr>");
		
				try (ResultSet result = preShowAllCategory.executeQuery()) {
					while(result.next()) {
						out.println("<tr>");
						out.println("<td>"+result.getInt("categoryId")+"</td>");
						out.println("<td>" +result.getString("categoryName")+ "</td>");
						out.println("<td>"+result.getString("categoryDescription")+"</td>");
						out.println("<td><img src='Images/"+result.getString("categoryImageUrl")+ "' height='120px' width='120px'/></td>");
						out.println("</tr>");
					}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
	}

}
