package org.fi.spring.secondbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"org.fi.spring.secondbootrest.restful"})
public class SecondbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondbootrestApplication.class, args);
	}

}
