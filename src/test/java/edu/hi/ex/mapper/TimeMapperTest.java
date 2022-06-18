package edu.hi.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class TimeMapperTest {

	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
        log.info("timeMapper class name: " + timeMapper.getClass().getName());
        log.info("timeMapper time: " + timeMapper.getTime());		
	}

	//XML 방식
    @Test
    public void testGetTime2() {
        log.info("getTime2");
        log.info("getTime2: " + timeMapper.getTime2());
    }

}
