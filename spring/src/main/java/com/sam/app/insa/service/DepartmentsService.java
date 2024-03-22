package com.sam.app.insa.service;

import java.util.List;
import java.util.Map;

public interface DepartmentsService {

	//목록 조회
	public List<Map<String, Object>> getDepartmentsList(DepartmentsVO vo);
}
