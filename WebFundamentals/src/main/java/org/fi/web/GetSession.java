package org.fi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetSession
 */
@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession(false);
		
		PrintWriter out =  response.getWriter();
		
		if(session == null)
		{
			out.println("NO SESSION FOR THIS USER ");
			return;
		}
		
		out.println("session Id " + session.getId()+ "<br/>");
		out.println("session last account time " + new Date(session.getLastAccessedTime()) + "<br/>");
		out.println("Session max inctive interval : "+session.getMaxInactiveInterval() + "<br/>");
		String user = (String)session.getAttribute("userName");
		out.println("Welcome user " + user);
	}

}
