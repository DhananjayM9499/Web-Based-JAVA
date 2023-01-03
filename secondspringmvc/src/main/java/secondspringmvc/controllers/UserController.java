package secondspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import secondspringmvc.pojo.UserInfo;
@Controller
public class UserController {
	@GetMapping("/login")
	public void prepareLoginUser(Model data) 
	{
	
		data.addAttribute("objUser",new UserInfo());
		
	}
@PostMapping("/authenticate")
public ModelAndView authenticateUser(@ModelAttribute("objUser")UserInfo objUser) {
	if(objUser.getUserName().equals("dhananjay") && objUser.getPassword().equals("cdac"))
			return new ModelAndView("Welcome","message","Welcome"+objUser.getUserName()+", to Online shopping");
	else
		return new ModelAndView("failure","errorMessage","Invalid username/password");
}

}
