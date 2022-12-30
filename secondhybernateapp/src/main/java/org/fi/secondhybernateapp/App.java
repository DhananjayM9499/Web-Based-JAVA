package org.fi.secondhybernateapp;

import java.util.Scanner;

import org.fi.secondhybernateapp.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 Configuration hibernateConfig= new Configuration();
    	    hibernateConfig.configure("MySql.cfg.xml");
    	    try(SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
    	    		Session hibernateSession = hibernateFactory.openSession();
    	    		Scanner scanner = new Scanner(System.in))
    	    {
    	    	System.out.println("Enter the user name");
    	    	String userName = scanner.next();
    	    	Users objUsers= hibernateSession.load(Users.class,userName);
    	    	System.out.println(objUsers);
    	    }
    }
}
