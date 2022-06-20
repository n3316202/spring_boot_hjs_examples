package edu.hi.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.hi.ex.service.EmpService;

@Controller
public class EmpController {

	/*
	 * 객체 주입을 위한 annotation = @Autowired
	 */
	@Autowired
	private EmpService empService;

	// http://localhost:8282/ex/emp/list로 치고 들어왔을때 받아내는메소드
	@GetMapping("/emp/list")
	public String list(Model model) {
		
		System.out.println("list().."); // 디버깅 문구
		System.out.println(empService.getList()); // 디버깅 문구

		model.addAttribute("empList", empService.getList());
		return "/emp/list"; // emp폴더의 list.jsp로 가라
	}

}
