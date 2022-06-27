package edu.hi.ex.service;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hi.ex.mapper.DeptMapper;
import edu.hi.ex.vo.DeptVO;


@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper mapper;
	
	@Override
	public List<DeptVO> getEmpDeptList() {
		
		return mapper.getEmpDeptList();
	}

	
}
