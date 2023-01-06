package org.fi.spring.resthibernateproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"org.fi.spring.resthibernateproduct.controllers"})
@EntityScan(basePackages = {"org.fi.spring.resthibernateproduct.entity"} )
public class ResthibernateproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResthibernateproductApplication.class, args);
	}

}
