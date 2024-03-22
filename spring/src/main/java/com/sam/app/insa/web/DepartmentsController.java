package com.sam.app.insa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sam.app.insa.service.DepartmentsService;
import com.sam.app.insa.service.DepartmentsVO;

@Controller

public class DepartmentsController {
	
	@Autowired DepartmentsService departmentsService;

	@RequestMapping("/departmentslist")
	public ModelAndView getDepartmentsList(DepartmentsVO vo) {
		ModelAndView mv  = new ModelAndView();
		
		mv.addObject("departmentsList", departmentsService.getDepartmentsList(vo));
		
		mv.setViewName("insa/departmentslist");
		return mv;
	}
	
}
