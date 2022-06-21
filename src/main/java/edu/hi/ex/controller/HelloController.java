package edu.hi.ex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

	@GetMapping("/")
	public String helo() {
		return "Hello World";
	}
	
	@GetMapping("/board")
	public ModelAndView board() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/restful");
		
		return mv;
	}

}
