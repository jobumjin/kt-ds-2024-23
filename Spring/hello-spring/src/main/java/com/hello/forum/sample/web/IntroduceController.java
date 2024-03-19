package com.hello.forum.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroduceController {

	
	// http://localhost:8080/introduce
	@GetMapping("/introduce")
	public String viewIntroducePage(Model model) {
		
		model.addAttribute("name","BeomJin Jo");
		model.addAttribute("age","27");
		model.addAttribute("adress","경기도 고양시");
		return "introduce";
	}
}
