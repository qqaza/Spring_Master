package com.example.demo.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;
@Mapper
public interface EmpMapper {
	List<EmpVo> getEmpList(EmpVo vo, SearchVO svo); //전체조회 , 페이징
	EmpVo getEmpInfo(int employeeId); //단건조회
	    int insertEmp(EmpVo empVO); // 등록
		int deleteEmp(int employeeId); // 삭제
		List<Map<String,Object>>getStat();
}
