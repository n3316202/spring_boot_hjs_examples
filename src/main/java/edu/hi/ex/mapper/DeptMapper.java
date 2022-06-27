package edu.hi.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.hi.ex.vo.DeptVO;
import edu.hi.ex.vo.EmpDeptVO;


@Mapper
public interface DeptMapper {
	public List<DeptVO> getList();
	public List<EmpDeptVO> getEmpDeptOneVOList();
	public List<DeptVO> getEmpDeptList();
	
}
