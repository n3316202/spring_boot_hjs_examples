package edu.hi.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    /**
     * 웹 API 테스트할 때 사용
     * 스프링 MVC 테스트의 시작점
     * HTTP GET,POST 등에 대해 API 테스트 가능
     * */
	@Autowired
    MockMvc mvc; //웹브라우저라고 생각 하면 좀더 쉽게 이해 할수 있다.
	
	@Test
	void testHello() throws Exception{
        mvc.perform(get("/")) //MockMvc를 통해 /hello 주소로 GET 요청
        	//mvc.perform()의 결과를 검증
        	.andExpect(status().isOk()) //200 상태
        	.andDo(print()); 
		 
	}

}
