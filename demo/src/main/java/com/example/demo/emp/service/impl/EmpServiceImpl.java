package com.example.demo.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

import lombok.Setter;

@Service //구현클래스에 서비스 
public class EmpServiceImpl implements EmpService {
	@Setter(onMethod_ = @Autowired)
	EmpMapper empMapper;   //@Autowired
	
	@Override
	public Map<String,Object> getEmpList(EmpVo vo, SearchVO svo) {
		Map<String,Object> map = new HashMap<String,Object>();
		//리스트와 전체건수
		map.put("data", empMapper.getEmpList(vo, svo));
		map.put("count", empMapper.getCount(vo, svo));
		
		return map;
	}

	@Override
	public EmpVo getEmpInfo(int employeeId) {
		return empMapper.getEmpInfo(employeeId);
	}

	@Override
	public int insertEmp(EmpVo empVO) {
		return empMapper.insertEmp(empVO);
	}

	@Override
	public int deleteEmp(int employeeId) {
		return empMapper.deleteEmp(employeeId);
	}

	@Override
	public List<Map<String, Object>> getStat() {
		return empMapper.getStat();
	}

}
