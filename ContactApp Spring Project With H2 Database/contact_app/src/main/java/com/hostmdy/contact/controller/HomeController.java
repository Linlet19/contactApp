package com.hostmdy.contact.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class HomeController {

	@GetMapping({"/","index","/home"})
	public String showHome(Model model) {
		model.addAttribute("title","Home - ContactApp");
		return "home";
	}
	
}
