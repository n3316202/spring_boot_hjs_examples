package edu.hi.ex.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("sprint")
public class SPrint implements Print{
	
	@Override
	public void print(String str) {
		System.out.println(str);
	}
}
