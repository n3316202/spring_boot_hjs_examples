package edu.hi.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RestBoardViewController {

	@GetMapping("/rest/board/list")
	public ModelAndView board() {
		
		log.info("ModelAndView board() ..");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/rest_list");
		
		return mv;
	}
	
}
