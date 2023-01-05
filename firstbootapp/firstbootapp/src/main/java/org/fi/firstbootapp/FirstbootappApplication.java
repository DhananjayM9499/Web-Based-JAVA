package org.fi.firstbootapp;

import org.fi.firstbootapp.beans.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages= {"org.fi.firstbootapp.beans"})
public class FirstbootappApplication implements CommandLineRunner {
	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(FirstbootappApplication.class, args);
	}
	@Override
	public void run(String... args)throws Exception
	{
		System.out.println("Hello boot application");
		Users objUser=(Users)applicationContext.getBean("objUser");
		System.out.println(objUser);
	}

}
