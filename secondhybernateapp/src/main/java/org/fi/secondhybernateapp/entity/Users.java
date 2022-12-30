package org.fi.secondhybernateapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users_0018")
public class Users {
@Id
@Column(name="username")
String userName;
@Column(name="password")
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
@Column String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}@Column String email;
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Users [userName=" +userName+",password="+password+",name="+name+",email="+email+"]";
}





}

