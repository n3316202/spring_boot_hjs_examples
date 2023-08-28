package edu.global.ex.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@WithMockUser(username = "admin", password = "admin")
	public void authAdminTest() throws Exception {		
		
		//로그인 테스트 
		mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect(status().isOk());
				
	}

	@Test
	public void loginSuccess() throws Exception {	
		String username = "user2";
		String password = "user2";
		
		// 로그인 통과 테스트
		mockMvc.perform(get("/login").with(user(username).roles("USER")))
			.andDo(print()).andExpect(status().isOk());
				
	}
	
	@Test
	@WithMockUser(username = "carrotpay", password = "ww1235", authorities = "ROLE_USER")
	public void userPageTest() throws Exception {		
		
		// 마이페이지
		mockMvc.perform(MockMvcRequestBuilders.get("/user/userHome"))
			.andExpect(MockMvcResultMatchers.status().isOk());
				
	}
	
	@Test
	@WithMockUser(username = "carrotpay", password = "ww1235", authorities = "ROLE_ADMIN")
	public void adminPageTest() throws Exception {		
		
		// 마이페이지
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminHome"))
			.andExpect(MockMvcResultMatchers.status().isOk());

				
	}
	
	
}
