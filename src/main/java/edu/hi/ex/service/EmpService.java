package edu.hi.ex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.hi.ex.dao.EmpDao;
import edu.hi.ex.vo.EmpVO;


/*
IOC 컨테이너에게 객체 생성하라고 명령하는 명령어 annotation 
*/
@Service
public class EmpService {
	
	/*
    	객체 주입을 위한 annotation = @Autowired
    */
	@Autowired
	private EmpDao empDao;
	
	public List<EmpVO> getList(){ 
			System.out.println("getList().."); //디버깅문구
		return empDao.selectList();
	}
}