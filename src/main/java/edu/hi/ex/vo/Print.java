package edu.hi.ex.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;


public interface Print {
	void print(String str);
}
