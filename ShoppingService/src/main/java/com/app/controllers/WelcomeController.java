package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	
	@RequestMapping("/ee")
	public String welcome(Model model) {
		model.addAttribute("message", "Welcome to Shopping Cart");
		return "welcome";
		
	}

}
