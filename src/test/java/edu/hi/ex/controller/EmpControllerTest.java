package edu.hi.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
@AutoConfigureMockMvc
class EmpControllerTest {

	@Autowired
	private MockMvc mockMvc;  // 클라이언트의 요청을 테스트할 컨트롤러로 전달하는 역할을 한다.
	

	@Test
	void testEmplist() throws Exception {
		
		 mockMvc.perform(get("/emp/list"))
		 		.andExpect(status().isOk())
				.andDo(print()); 
		
		
	}

}
