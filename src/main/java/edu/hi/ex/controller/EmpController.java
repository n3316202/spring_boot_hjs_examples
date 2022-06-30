package edu.hi.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hi.ex.service.DeptService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmpController {

	@Autowired
	private DeptService service;
	
	@GetMapping("/empDept")
	public String empDept(Model model) {
		log.info("empDept () ..");
		
		model.addAttribute("empDeptList", service.getEmpDeptList());		
		
		System.out.println(service.getEmpDeptList());
		
		return "empDept";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		log.info("index () ..");
		
		model.addAttribute("empDeptList", service.getEmpDeptList());		
		
		System.out.println(service.getEmpDeptList());
		
		return "index";
	}
}
