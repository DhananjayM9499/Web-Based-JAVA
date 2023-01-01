package org.fi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="users_0018")
@NamedQueries({@NamedQuery(name="validateUser",query = "select objUser.name,objUser.email from Users objUser.userName=?1 and objUser.password=?2")})
@NamedNativeQueries({@NamedNativeQuery(name="addCategory",query="insert into category_0018 values(?1,?2,?3,?4)")})
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
