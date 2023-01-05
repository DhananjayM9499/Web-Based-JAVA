package org.fi.spring.secondbootrest.restful;

import org.fi.spring.secondbootrest.dto.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@GetMapping("/authenticate")
public UserInfo processAuthenticate(@RequestParam("userName")String userName,@RequestParam("password")String password)
{
	if(userName.equals("dhananjay") && password.equals("cdac"))
	{
		UserInfo objUser = new UserInfo();
		objUser.setUserName("Dhananjay");
		objUser.setPassword("*******");
		objUser.setName("Dhananjay Mohokar");
		objUser.setEmail("dhananjay@mohokar.com");
	
		return objUser;
		}
	else
	return null;
}
}
