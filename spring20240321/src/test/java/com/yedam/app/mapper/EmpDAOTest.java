package com.yedam.app.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpDAO;
import com.yedam.app.emp.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EmpDAOTest {
	
	@Autowired EmpMapper empDAO;
	
	@Test
	public void getInfo() {
		String employeeId = "100";
		Map<String,Object> map = empDAO.getInfo(employeeId);
		assertEquals(map.get("EMPLOYEE_ID").toString(), employeeId);
	}
}