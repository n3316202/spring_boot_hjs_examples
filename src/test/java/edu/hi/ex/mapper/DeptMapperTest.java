package edu.hi.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.BootstrapWith;

import edu.hi.ex.vo.DeptVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DeptMapperTest {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Test
	public void testGetList() {

		System.out.println(deptMapper);
		System.out.println(deptMapper.getList().size());
		
		for (DeptVO vo : deptMapper.getList()) {
			log.info(vo.getLoc());
			System.out.println(vo.getDeptno());
		}	

	}
}
