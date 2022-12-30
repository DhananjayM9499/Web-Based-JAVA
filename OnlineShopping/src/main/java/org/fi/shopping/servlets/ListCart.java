package org.fi.shopping.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fi.shopping.cart.Cart;
import org.fi.shopping.pojo.CartItem;

@WebServlet("/ListCart")
public class ListCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			response.sendRedirect("Login.html");
			return;
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Welcome <b>" + session.getAttribute("userName")+"</b><br/>");
		Cart objCart = (Cart)session.getAttribute("cart");
		
		if(objCart == null )
		{
			out.println("Your Cart is Empty.");
			return;
			
		}
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Category Id</th>");
		out.println("<th>Product Id</th>");
		out.println("<th>Price</th>");
		out.println("</tr>");
		
		double total = 0.0;
		Iterator<CartItem> iter = objCart.getAllItems();
		while(iter.hasNext())
		{
			CartItem item = iter.next();
			out.println("<tr>");
			out.println("<td>"+ item.getCategoryId()+"</td>");
			out.println("<td>"+ item.getProductId()+"</td>");
			out.println("<td>"+ item.getProductPrice()+"</td>");
			out.println("</tr>");
			total += item.getProductPrice();
		}
		out.println("</table>");
		out.println("Total : <b>" + total + "</b><br/>");
		out.println("<a href ='Category'>ContinueShopping</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<a href ='Logout'>Sign out</a><br/>");
		out.println("</body>");
		out.println("</html>");
	
	}

}

















