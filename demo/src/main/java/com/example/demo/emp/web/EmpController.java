package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

@Controller // 컨테이너 빈 등록 + 사용자요청처리할 커맨드 핸들러 변환
public class EmpController {
	
	@Autowired EmpMapper mapper; //의존성 주입 (DI = Dependency Injection)
	
	@RequestMapping("/ajaxEmp")
	@ResponseBody
	public List<EmpVo> ajaxEmp(){
		return mapper.getEmpList(null, null);
	}
	
	//ajax응답과 비슷함
	@PostMapping("/insert2")  //148교재
	public ResponseEntity<EmpVo> insert2(EmpVo vo) {
		return new ResponseEntity<>(vo , HttpStatus.OK);
	}
	
	@RequestMapping("/empResult") //redirect URL
	public String result() { 
		return "result";
	}
	
	@RequestMapping("/empList") //forward
	public String empList(Model model, EmpVo vo, SearchVO svo){
		model.addAttribute("copmpanyName", "<i>예담주식회사</i>");
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "empList"; 
	}
	
	@PostMapping("/insert3")   //redirect 등록 수정 삭제 할때 사용
	public String insert3(EmpVo vo, RedirectAttributes rttr) {
		System.out.println("등록:" + vo);
		rttr.addAttribute("insertResult", "성공");
		rttr.addFlashAttribute("flashResult", "한번만");
		return "redirect:empResult";
	}
	
	
	
	@PostMapping("/insert")

	public ModelAndView insert(@ModelAttribute("emp") EmpVo vo, Model model) {
		System.out.println(vo);
//		mapper.insertEmp(vo);
		//커맨드객체는 자동으로 model에 추가되고 view페이지에 볼수있음
		//model.addAttribute("empVo", vo);
//		model.addAttribute("insertResult", "success");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("insertResult", "success");
		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return mv; //페이지 명(result)
		
	}
		
	
	@GetMapping("/update/{empId}")
	public String update(@PathVariable int empId) {
		System.out.println(empId);
		return "index"; //리턴값이 /tamplate/index.html 을 찾아서 페이지를 넘겨준다
	}
	
	@GetMapping("/delete")
	public String delete(int employeeId, String name) {
		System.out.println(employeeId + ":" + name);
		return "index"; //리턴값이 /tamplate/index.html 을 찾아서 페이지를 넘겨준다
	}
	
	@GetMapping("/")
	public String test() {
		return "index"; //리턴값이 /tamplate/index.html 을 찾아서 페이지를 넘겨준다
	}
	
	
	
//	@RequestMapping("/empList")
//	public String empList(Model model,EmpVo vo, SearchVO svo){
//		model.addAttribute("empList", mapper.getEmpList(vo, svo));
//		return "empList"; 
//	}
		
}