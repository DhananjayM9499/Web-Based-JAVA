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
 * Servlet implementation class ShowAllProduct
 */
@WebServlet("/ShowProduct")
public class ShowAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	PreparedStatement preShowAllProduct;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			
			ServletContext appliction = getServletContext();
			
			connection =((Connection)appliction.getAttribute("golbalConnection"));
			
			System.out.println("ShowProduct :-" + connection);
			
			preShowAllProduct = connection.prepareStatement("select * from product_0013 ");
		
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
			if(preShowAllProduct!=null) {
				preShowAllProduct.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>productID</th>");
		out.println("<th>productName</th>");
		out.println("<th>productDescription</th>");
		out.println("<th>productImgUrl</th>");
		out.println("<th>productPrice</th>");
		out.println("</tr>");
		
				try (ResultSet result = preShowAllProduct.executeQuery()) {
					while(result.next()) {
						out.println("<tr>");
						out.println("<td>"+result.getInt("productID")+"</td>");
						out.println("<td>" +result.getString("productName")+ "</td>");
						out.println("<td>"+result.getString("productDescription")+"</td>");
						out.println("<td><img src='Images/"+result.getString("productImgUrl")+ "' height='120px' width='120px'/></td>");
						out.println("<td>"+result.getString("productPrice")+ "</td>");
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
