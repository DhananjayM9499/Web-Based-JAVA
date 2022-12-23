package org.fi.jdbc;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//1. Register User
//2. Delete User
//3. Change Password
//4. Show user details
//5. Update User
//6. Exit

public class Program
{

	public static void main(String[] args)
	{
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("database.properties"));
			String driverClassName =props.getProperty("db.driverName");
			String url = props.getProperty("db.url");
			String dbuserName = props.getProperty("db.userName");
			String dbpassword = props.getProperty("db.password");		
			Class.forName(driverClassName);
		try(Connection connection = DriverManager.getConnection(url,dbuserName,dbpassword);
				Statement stSelect = connection.createStatement();
				Scanner scanner = new Scanner(System.in);)
		{
			System.out.println("Enter the username to register");
			String userName = scanner.next();
			System.out.println("Enter the Password");
			String password = scanner.next();
			System.out.println("Enter the name ");
			String name = scanner.next();
			System.out.println("Enter the E-mail");
			String email = scanner.next();
			
			String sql = "insert into users_0018 values('"+ userName +"','"+ password+"','"+ name +"','"+ email+"')";
			stSelect.executeUpdate(sql);
			System.out.println("user registered");
			
		}
		catch(SQLException sql)
		{
			sql.printStackTrace();
		}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}