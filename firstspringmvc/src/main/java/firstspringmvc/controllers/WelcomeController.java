package firstspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping("/hello")
	public String welcome() {
		System.out.println("Welcome of the welcom controller fire");
		return "welcome";// Identifies the name of the view that has Welcome function
	}
}
