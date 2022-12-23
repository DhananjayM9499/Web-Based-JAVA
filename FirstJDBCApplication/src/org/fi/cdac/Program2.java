package org.fi.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Program2 {

	public static void main(String[] args) {
		//1. Declare all variables required for connections
		Connection connection = null;
		Statement stSelect = null;
		ResultSet result = null;
		try {
			//2. Load to the database driver into memory
			//MySql Type 4 driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//3. Establish a connection using the Driver Manager
			//DriverManager.getConnection("jdbc:mysql://ip:port/schema",userName,Password)
	       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/actsdelhi","root","Danny@1252");
		//4. Create a Statement that will allow me to fire queries
	       stSelect = connection.createStatement();
	       result = stSelect.executeQuery("select* from users_0018 where username = 'rohit'");
	       //5. Iterate over the result generated to display the data
	       while(result.next())
	       {
	    	   System.out.println(result.getString("username"));
	    	   System.out.println(result.getString("password"));
	    	   System.out.println(result.getString(3));
	    	   System.out.println(result.getString(4));
	    	   System.out.println("--------------------------------------------");
	       }
		} catch ( ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(result!= null)
					result.close();
				if(stSelect!= null)
					stSelect.close();
				if(connection!= null)
					connection.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
	}

}