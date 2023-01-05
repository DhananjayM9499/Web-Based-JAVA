package org.fi.firstbootapp.beans;

import org.springframework.stereotype.Component;

@Component("objUser")
public class Users {
String userName;
String password;
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
