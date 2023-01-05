package org.fi.springbootmvc.controllers;

import org.fi.springbootmvc.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

	@GetMapping("/login")
	public void prepareUser(Model data)
	{
		System.out.println("Controller Fired....");
		data.addAttribute("objUser", new UserInfo());
	}
	@PostMapping("/authenticate")
	public String authenticate(@ModelAttribute("objUser")UserInfo objUser)
	{
		if(objUser.getUserName().equals("dhananjay") && objUser.getPassword().equals("cdac"))
			return "welcome";
		else
			return "failure";
	}
	
}