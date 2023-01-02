package org.fi.SpringSecond.config;

import org.fi.SpringSecond.beans.Account;
import org.fi.SpringSecond.beans.AmazonAccount;
import org.fi.SpringSecond.beans.Category;
import org.fi.SpringSecond.beans.FlipkartAccount;
import org.fi.SpringSecond.beans.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfigurator 
{
	@Autowired
	Environment environment;
	/*
	 * @Bean public Users objUsers(@Value("${user.userName}")String
	 * userName, @Value("${user.password}") String password) { Users objUsers = new
	 * Users(); objUsers.setUserName(userName); objUsers.setPassword(password);
	 * return objUsers; }
	 */
	
	@Bean(initMethod ="initUser",destroyMethod ="destroy")
	public Users objUsers() {
		String pwd = environment.getProperty("user.password");
		Users objUsers =new Users();
		objUsers.setUserName(environment.getProperty("user.username"));
		objUsers.setPassword(pwd);
		return objUsers;
	}

	@Bean
	public Account objFlip() {
		return new FlipkartAccount();
	}

	@Bean
	public Account objAccount() {
		return new AmazonAccount();
	}

	@Bean
	public Category objCategory() {
		return new Category();
	}

}
