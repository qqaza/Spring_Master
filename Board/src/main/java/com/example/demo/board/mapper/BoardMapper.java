package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;

@Mapper
public interface BoardMapper {
	List<EmpVo> getEmpList(@Param("vo") EmpVo emp, SearchVO svo);
	EmpVo getEmpInfo(int employeeId);
	int insertEmp(EmpVo empVO);
	int deleteEmp(int employeeId);
	List<Map<String, Object>> getStat();
	int updateEmp(EmpVo empVO);
	
	// @Select("select count(*) from employees")
	public long getCount();
}
