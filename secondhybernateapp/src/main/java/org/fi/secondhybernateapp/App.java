package org.fi.secondhybernateapp;

import java.util.List;
import java.util.Scanner;

import org.fi.secondhybernateapp.entity.ProductId;
import org.fi.secondhybernateapp.entity.Products;
import org.fi.secondhybernateapp.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	final int SHOW_ALL=1;
    	final int SHOW_BY_NAME=2;
    	final int ADD_CATEGORY =3;
    	final int  EXIT=4;
    	
    	 Configuration hibernateConfig= new Configuration();
    	    hibernateConfig.configure("MySql.cfg.xml");
    	    try(SessionFactory hibernateFactory = hibernateConfig.buildSessionFactory();
    	    		Session hibernateSession = hibernateFactory.openSession();
    	    		Scanner scanner = new Scanner(System.in))
    	    {
    	    	int choice=0;
    	    	while(choice!=EXIT) {
    	    		System.out.println("-----------------------");
    	    		System.out.println("         Menu            ");
    	    		System.out.println("-----------------------");
    	    		System.out.println("1. Show All\n2. Show By Name\n3. Add Category\n4. Exit ");
    	    		System.out.print("Enter the choice :");
    				choice = scanner.nextInt();
				/*
				 * System.out.println("Enter the user name"); String userName = scanner.next();
				 * Users objUsers= hibernateSession.load(Users.class,userName);
				 * System.out.println(objUsers);
				 */
    	    	//HQL
    	    	switch(choice) {
    	    	case 1: {
    	    	Query<Users> query= hibernateSession.createQuery("select OBJECT(objUser) from Users objUser");
    	    	List<Users> list = query.list();
    	    	for(Users objUser : list)
    	    	{
    	    		System.out.println(objUser);
    	    		
    	    	}
    	    	System.out.println("________________________________________________________________________________________");
    	    	}break;
    	    	
    	    	case 2:
    	    		System.out.println("Enter the name to get the details");
    	    		String usName = scanner.next();
    	    		Query<Users> query= hibernateSession.createQuery("select OBJECT(objUser) from Users objUser where objUser.userName=:name");
    	    		query.setParameter("name", usName);
    	    		List result = query.list(); 	
    	    		System.out.println(result);
    	    	break;
    	    	
    	    	case 3:
    	    		Query sqlQuery= hibernateSession.getNamedNativeQuery("addCategory");
    	    		System.out.println("Enter category Id");
    	    		String catId = scanner.next();
    	    		System.out.println("Enter category Name");
    	    		String catName = scanner.next();
    	    		System.out.println("Enter category Description");
    	    		String catDesc = scanner.next();
    	    		System.out.println("Enter category Image Url");
    	    		String catImgUrl = scanner.next();
    	    		sqlQuery.setParameter(1, catId);
    	    		sqlQuery.setParameter(2, catName);
    	    		sqlQuery.setParameter(3, catDesc);
    	    		sqlQuery.setParameter(4, catImgUrl);
    	    		System.out.println("Category Added");
    	    		hibernateSession.beginTransaction();
    	    		sqlQuery.executeUpdate();
    	    		hibernateSession.getTransaction().commit();
    	    		
    	    		break;
    	    		
    	    	case 5:
    	    		System.out.println("Enter the Category Id");
    	    		int categoryId = scanner.nextInt();
    	    		System.out.println("Enter the product Id");
    	    		int prodId = scanner.nextInt();
    	    		
    	    		ProductId id = new ProductId(categoryId,prodId);
    	    		Products objProduct = hibernateSession.load(Products.class, id);
    	    		System.out.println(objProduct.getProductName());
    	    		System.out.println(objProduct.getProductPrice());
    	    		
    	    		
    	    	default:
    	    		System.out.println("Have a nice day.......!");
    	    	
    	    	}
    	    	
    	    	
    	    	}
    	    }
    }
}
