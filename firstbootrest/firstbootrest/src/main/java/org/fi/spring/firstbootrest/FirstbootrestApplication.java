package org.fi.spring.firstbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.fi.spring.firstbootrest.controllers"} )
public class FirstbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootrestApplication.class, args);
	}

}