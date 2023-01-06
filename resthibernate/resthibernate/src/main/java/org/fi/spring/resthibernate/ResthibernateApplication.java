package org.fi.spring.resthibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"org.fi.spring.resthibernate.controllers"})
@EntityScan(basePackages = {"org.fi.spring.resthibernate.entity"} )
public class ResthibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResthibernateApplication.class, args);
	}

}
