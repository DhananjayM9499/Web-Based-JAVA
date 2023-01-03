package org.fi.spring.fourthspringjdbc;

import java.util.List;
import java.util.Scanner;

import org.fi.spring.fourthspringjdbc.DAO.CategoryDAO;
import org.fi.spring.fourthspringjdbc.beans.Category;
import org.fi.spring.fourthspringjdbc.config.AppConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AppConfigurator.class); Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter id");
			int catId = scanner.nextInt();
			System.out.println("Enter name");
			String catName = scanner.next();
			System.out.println("Enter the Desc");
			String catDesc = scanner.next();
			System.out.println("Enter the Image");
			String catImage = scanner.next();

			Category objCategory = (Category) applicationContext.getBean("objCategory");
			CategoryDAO daoCategory = (CategoryDAO) applicationContext.getBean("objCategoryDAO");
			objCategory.setCategoryId(catId);
			objCategory.setCategoryName(catName);
			objCategory.setCategoryDescription(catDesc);
			objCategory.setCategoryImageUrl(catImage);
			daoCategory.addCategory(objCategory);
			System.out.println("Record Saved....!");
			
			List<Category> list = daoCategory.getAllCategories();
			for(Category objShowCategory:list) {
				System.out.println(objShowCategory.getCategoryId());
				System.out.println(objShowCategory.getCategoryName());
				System.out.println(objShowCategory.getCategoryDescription());
				System.out.println(objShowCategory.getCategoryImageUrl());
				System.out.println("------------------------------------");
				
			}
		}

	}
}
