package com.sam.app.insa.mapper;

import java.util.List;
import java.util.Map;

import com.sam.app.insa.service.DepartmentsVO;

public interface DepartmentsMapper {

	public List<Map<String, Object>> getDepartmentsList(DepartmentsVO vo) ;
}
