package edu.hi.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloJspController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "bye";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index.html";
	}

}
