package org.fi.firstmavenproject;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      //  System.out.println( "Hello World!" );
    Configuration hibernateConfig= new Configuration();
    hibernateConfig.configure("Basic.cfg.xml");
    try(SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
    		Session hibernateSession = hibernateFactory.openSession();)
    {
    	storeRecord(hibernateSession);
    	//loadRecord(hibernateSession);
    }
    }
    private static void loadRecord(Session hibernateSession) {
    	
    	Users objUser = (Users)hibernateSession.load(Users.class,"rutu");
    	System.out.println(objUser.getUserName());
    	System.out.println(objUser.getPassword());
    	System.out.println(objUser.getName());
    	System.out.println(objUser.getEmail());
    }
    private static void storeRecord(Session hibernateSession) {
    	Scanner scanner = new Scanner (System.in);
    	
    	System.out.println("Enter the User Name");
    	String user = scanner.next();
    	
    	System.out.println("Enter the Password");
    	String password = scanner.next();
    	
    	System.out.println("Enter the Name");
    	String name = scanner.next();
    	
    	System.out.println("Enter the email");
    	String email = scanner.next();
    	
    	Users objUser = new Users(user,password,name,email);
    	
    	Transaction tx = hibernateSession.beginTransaction();
    	hibernateSession.save(objUser);
    	tx.commit();
    	System.out.println("Record Save");
     	
    	
    }
}
