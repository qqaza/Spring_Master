package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.paging.Paging;
import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;
import com.example.demo.emp.service.EmpService;

@RestController
public class EmpRestController {
	
	@Autowired EmpService service;
	
	//리스트 페이지 이동
	@GetMapping("/empMng") //forward 리스트 출력
	public ModelAndView empMng() { 
		ModelAndView mv = new ModelAndView("empMng");
		return mv;
	}
		
	
	//값이 여러개이면 map을 사용해야함.
	
	//사원리스트 데이터 ajax페이징
	@GetMapping("/ajax/empList") //ajax model필요 없음
	//@ResponseBody // vo -> json String 변환
	public Map<String,Object> empList(EmpVo vo, SearchVO svo, Paging pvo) {
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast()); 
		
		Map<String,Object> map = service.getEmpList(vo, svo);
		pvo.setTotalRecord((Long)map.get("count"));
		map.put("paging",pvo);
		
		return map;
	}
	
	//등록
	
	@PostMapping("/ajax/emp")
	public EmpVo save(@RequestBody EmpVo vo) {
		System.out.println(vo);
		service.insertEmp(vo); //주석풀면 등록 가능함.
		return vo;
	}
	
	//단건조회
	@GetMapping("/ajax/emp/{empId}")
	
	public EmpVo info(@PathVariable int empId) {
		return service.getEmpInfo(empId);
	}
	
	//차트
	@GetMapping("/ajax/empStat")
	public List<Map<String,Object>> stat() {
		return service.getStat();
	}
	
	
}
