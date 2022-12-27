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
 * Servlet implementation class CreateSession
 */
@WebServlet("/CreateSession")
public class CreateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**if
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	PrintWriter out = response.getWriter();
	out.println("Session ID : " + session.getId()+"<br/>");
	out.println("Session last acc time : " + new Date(session.getLastAccessedTime())+ "<br/>");
	out.println("Session max Inactive Interval : " + session.getMaxInactiveInterval()+ "<br/>");
	session.setAttribute("userName","Dhananjay - Cdac");
	
	}

}
