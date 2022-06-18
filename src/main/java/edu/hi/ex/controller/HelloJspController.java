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
}
