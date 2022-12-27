package org.fi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet 
{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException,ServletException
	{
		PrintWriter out = response.getWriter();// write in the clients end 
	    //server side code
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>" + new Date() + "</h1>");
		out.println("</body>");
		out.println("</html>");
		System.out.println("doget of the timeSerblet has been fired @" + new Date());
	}

}
