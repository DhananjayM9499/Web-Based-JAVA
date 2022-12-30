package org.fi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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


@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	Connection connection;
	PreparedStatement preadmin;
		
	@Override
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	
	try {
		
		ServletContext application =getServletContext();
		
		String driverClass=application.getInitParameter("driverClass");
		String url =application.getInitParameter("url");
		String user=application.getInitParameter("dbUser");
		String pwd=application.getInitParameter("dbpaswword");
		
		Class.forName(driverClass);
		
	 connection = DriverManager.getConnection(url,user,pwd);
	 
	 application.setAttribute("golbalConnection", connection);
	 
	 System.out.println("Aadmin: " + connection);
	 
	 preadmin = connection.prepareStatement("select * from users_0013 where userName=? and password=?");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	
	public void destroy() {
		
		try {
			if(preadmin!=null) {
				preadmin.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		
		try {
			preadmin.clearParameters();
			
			preadmin.setString(1,userName);
			preadmin.setString(2,password);
			

			try (ResultSet result = preadmin.executeQuery()) {
				if(result.next()) {
				response.sendRedirect("welcom.html");
					
				}
				else {
					out.println("Invalid");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
