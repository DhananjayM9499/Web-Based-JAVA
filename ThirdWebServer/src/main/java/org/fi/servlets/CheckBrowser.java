package org.fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBrowser
 */
@WebServlet("/CheckBrowser")
public class CheckBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  = response.getWriter();
		String headerValue = request.getHeader("user-agent");
		if(headerValue.indexOf("Chrome")!=-1)
		out.println("You are using Google crome Browser");
		
		else if(headerValue.indexOf("Edge")!=-1)
		out.println("You are using Microsoft Edge");
		
		else if(headerValue.indexOf("Firefox")!=-1)
		out.println("You are using Mozilla Firefox");
		
		else 
			out.println("You are using an alien browser");
	}

}
