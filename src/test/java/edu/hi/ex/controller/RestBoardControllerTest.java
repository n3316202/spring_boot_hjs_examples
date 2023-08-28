package edu.global.ex.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class RestBoardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test // 테스트 실행하기 전에 먼저 실행해야 될 것
	public void testBoards_write() throws Exception {
		BoardVO board = new BoardVO();
		board.setBcontent("호호호");
		board.setBname("하하하");
		board.setBtitle("굿굿굿");
		
	
		String jsonStr = new ObjectMapper().writeValueAsString(board); //  new Gson().toJson(board);
		
		log.info(jsonStr);
		
		mockMvc.perform(post("/boards/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(jsonStr))
					.andExpect(status().is(200))
					.andDo(MockMvcResultHandlers.print());
			

	}

}
