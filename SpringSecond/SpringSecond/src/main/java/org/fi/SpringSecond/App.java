package org.fi.SpringSecond;

import java.util.Scanner;

import org.fi.SpringSecond.beans.Account;
import org.fi.SpringSecond.config.AppConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

		System.out.println("starting spring Container");
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AppConfigurator.class); Scanner scanner = new Scanner(System.in);

		) {
			Account amazonAccount = (Account) applicationContext.getBean("objAccount");
			System.out.println(amazonAccount);
			Account flipkartAccount = (Account) applicationContext.getBean("objFlip");
			System.out.println(flipkartAccount);
		}
	}
}
