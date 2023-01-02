package org.fi.SpringSecond.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;


@Component
public class Users {
	String userName;
	String password;
	
	public Users() {
		System.out.println("Users ctor fired....");
	}
	
	@PostConstruct
	public void initUser()
	{
		System.out.println("iniy method of the bean fired...");
		
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy method of user");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
