package org.fi.spring.secondbootrest.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@GetMapping("/authenticate")
public boolean processAuthenticate(@RequestParam("userName")String userName,@RequestParam("password")String password)
{
	if(userName.equals("dhananjay") && password.equals("cdac"))
		return true;
	else
	return false;
}
}
