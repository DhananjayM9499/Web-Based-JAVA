package org.fi.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		final int REGISTER_USER = 1;
		final int DELETE_USER = 2;
		final int CHANGE_PASSWORD = 3;
		final int SHOW_USER_DETAILS = 4;
		final int SHOW_ALL_USER_DETAILS = 5;
		final int UPDATE_USER = 6;
		final int EXIT = 7;
		Scanner scanner = new Scanner(System.in);
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("database.properties"));
			String driverClassName = props.getProperty("db.driverName");
			String url = props.getProperty("db.url");
			String dbuserName = props.getProperty("db.userName");
			String dbpassword = props.getProperty("db.password");
			Class.forName(driverClassName);

			int choice = 0;
			while (choice != EXIT) {
				System.out.println(
						"-----MENU fOR APPLICATION-----\n1. Register User\n2. Delete User\n3. Change Password\n4. Show user details\n5. Show details of all users\n6. Update User\n7. Exit");
				System.out.print("Enter the choice :");
				choice = scanner.nextInt();

				try (Connection connection = DriverManager.getConnection(url, dbuserName, dbpassword);)

				{
					switch (choice) {

					case REGISTER_USER:

						PreparedStatement psInsert = connection
								.prepareStatement("insert into users_0018 values(?,?,?,?)");
						System.out.println("Enter the username to register");
						String userName = scanner.next();
						System.out.println("Enter the Password");
						String password = scanner.next();
						System.out.println("Enter the name ");
						String name = scanner.next();
						System.out.println("Enter the E-mail");
						String email = scanner.next();
						psInsert.clearParameters();
						psInsert.setString(1, userName);
						psInsert.setString(2, password);
						psInsert.setString(3, name);
						psInsert.setString(4, email);
						System.out.println("user registered");
						psInsert.executeUpdate();
//						psInsert.clearParameters();
						break;

					case DELETE_USER:
						System.out.println("Enter the user name to be deleted");
						String uName = scanner.next();
						PreparedStatement psDelete = connection
								.prepareStatement("DELETE FROM users_0018 WHERE userName = ( ? )");
						psDelete.setString(1, uName);
						psDelete.executeUpdate();
						System.out.println("Deleted user : " + uName);
						break;

					case CHANGE_PASSWORD:
						System.out.println("Enter the User name to change password");
						String usName = scanner.next();
						System.out.println("Enter new password : ");
						String newPassword = scanner.next();
						PreparedStatement psUpdatePassword = connection
								.prepareStatement("update users_0018 set password=( ? ) where userName = ( ? )");
						psUpdatePassword.setString(2, usName);
						psUpdatePassword.setString(1, newPassword);
						psUpdatePassword.execute();
						System.out.println("Password changed Successfully!!! ");

					case SHOW_USER_DETAILS:
						System.out.println("Enter the User Name ");
						String nameOfUser = scanner.next();
						PreparedStatement psShowDetails = connection
								.prepareStatement("Select * from users_0018 where userName = ?  ");
						psShowDetails.setString(1, nameOfUser);
						ResultSet result = psShowDetails.executeQuery();
						while (result.next()) {
							System.out.println("--------------------------------------------");
							System.out.println("User Name : " + result.getString(1));
							System.out.println("Password : " + result.getString(2));
							System.out.println("Name : " + result.getString(3));
							System.out.println("E-mail : " + result.getString(4));
							System.out.println("--------------------------------------------");
						}

						break;

					case SHOW_ALL_USER_DETAILS:
						PreparedStatement psShowAllDetails = connection.prepareStatement("Select * from users_0018 ");
						ResultSet allResult = psShowAllDetails.executeQuery();
						while (allResult.next()) {
							System.out.println("--------------------------------------------");
							System.out.println("User Name : " + allResult.getString(1));
							System.out.println("Password : " + allResult.getString(2));
							System.out.println("Name : " + allResult.getString(3));
							System.out.println("E-mail : " + allResult.getString(4));
							System.out.println("--------------------------------------------");
						}

						break;
					case UPDATE_USER:
						System.out.println("Enter the user name to update the details");
						String urName = scanner.next();
						PreparedStatement psUpdate = connection.prepareStatement(
								"update users_0018 set password=?, name=?,email=? where userName = ? ");
						psUpdate.setString(4, urName);
						System.out.println("Enter new Password");
						String upPassword = scanner.next();
						System.out.println("Enter new name ");
						String upName = scanner.next();
						System.out.println("Enter new E-mail");
						String upEmail = scanner.next();
						psUpdate.setString(1, upPassword);
						psUpdate.setString(2, upName);
						psUpdate.setString(3, upEmail);
						psUpdate.execute();
						break;

					case EXIT:
						System.out.println("Chala jaa ****");
						break;
					default:
						System.out.println("Enter correct choice");
					}
				}
			}
		} catch (SQLException sql) {
			sql.printStackTrace();
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
