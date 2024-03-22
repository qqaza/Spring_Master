package com.sam.app.insa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.app.insa.mapper.DepartmentsMapper;
import com.sam.app.insa.service.DepartmentsService;
import com.sam.app.insa.service.DepartmentsVO;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{
	
	@Autowired DepartmentsMapper departmentsMapper;
	
	@Override
	public List<Map<String, Object>> getDepartmentsList(DepartmentsVO vo) {
		return departmentsMapper.getDepartmentsList(vo);
	}

	




}
