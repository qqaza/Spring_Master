package com.example.demo.emp.service;

import java.util.List;
import java.util.Map;
import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;


public interface EmpService {
	//view페이지에서 사용자가 필요하는것을 서비스에 입력(사용자가 요청하는것을 여기 작성)
	Map<String,Object> getEmpList(EmpVo vo, SearchVO svo); //전체조회 , 페이징
	EmpVo getEmpInfo(int employeeId); //단건조회
	int insertEmp(EmpVo empVO); // 등록
	int deleteEmp(int employeeId); // 삭제
	List<Map<String,Object>> getStat(); //부서별 인원수 조회
}
