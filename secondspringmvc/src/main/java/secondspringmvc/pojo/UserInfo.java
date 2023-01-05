package secondspringmvc.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserInfo {
	@Id
	@Column(name="username")
	String userName;
	@Column(name="password")
	String password ;
	@Column(name="name")
	String name ;
	@Column(name="email")
	String email ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
