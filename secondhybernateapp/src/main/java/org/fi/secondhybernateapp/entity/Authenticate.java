package org.fi.secondhybernateapp.entity;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class Authenticate
 */
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=getServletContext();
		SessionFactory hibernateFactory = (SessionFactory) application.getAttribute("hibernateFactory");
		
		try(Session hibernateSession = hibernateFactory.openSession())
		{
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			Users objuser=hibernateSession.load(Users.class, userName);
			String userNameTmp=objuser.getUserName();
			String passwordTmp=objuser.getUserName();
			if(password.equals(passwordTmp)){
				HttpSession session=request.getSession();
				session.setAttribute("userName", userName);
				response.sendRedirect("Category.jsp");
			}
			else { response.sendRedirect("Login.html");
				
			}
			
			
		// TODO Auto-generated method stub
	}

}}