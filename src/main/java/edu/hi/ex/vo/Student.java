package edu.hi.ex.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Student {
	@Value("홍길동")
	private String name = "홍길동";
	
	@Value("25")
	private int age = 15;
}
