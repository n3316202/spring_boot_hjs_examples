package edu.hi.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class StudentTest {

	//@Resource, @Autowired, @Inject 이 태그들의 차이점은 의존 객체를 찾는방식이 다르다
	@Autowired
	private Student student;
	
	@Resource(name = "lprint")
	private Print print;
		
		
	@Test
	void testExist() {
		assertNotNull(print);
		
		assertNotNull(student);
		log.info(student.getName());
		log.info("나이" + student.getAge());
		
		
	}

}
