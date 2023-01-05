package org.fi.springbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.fi.springbootmvc.controllers"})
public class SpringbootmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmvcApplication.class, args);
	}

}