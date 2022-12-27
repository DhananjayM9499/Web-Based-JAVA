package org.fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/Headers")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Enumeration<String> headerNames = request.getHeaderNames();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");	
		out.println("<th>Name</th>");
		out.println("<th>Value</th>");	
		out.println("</tr>");
		
		while(headerNames.hasMoreElements())
		{
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
		out.println("<tr>");
		out.println("<td>" + headerName + "</td>");
		out.println("<td>" + headerValue + "</td>");
		out.println("</tr>");
		}
	out.println("</table>");
	out.println("</html>");
	out.println("</body>");
	}

}
