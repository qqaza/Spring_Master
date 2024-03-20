package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

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

import com.example.demo.common.paging.Paging;
import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.service.EmpService;

@Controller // 컨테이너 빈 등록 + 사용자요청처리할 커맨드 핸들러 변환

public class EmpController {
	
	@Autowired EmpService empService; //의존성 주입 (DI = Dependency Injection)
	

	//ajax응답과 비슷함
	@PostMapping("/insert2")  //148교재
	public ResponseEntity<EmpVo> insert2(EmpVo vo) {
		return new ResponseEntity<>(vo , HttpStatus.OK);
	}
	
	@RequestMapping("/empResult") //redirect URL
	public String result() { 
		return "result";
	}
	
	@RequestMapping("/empList") //forward 리스트 출력
	public String empList(Model model, EmpVo vo, SearchVO svo, Paging pvo){
		
		//페이징 처리 + 목록조회
		pvo.setPageUnit(5); //데이터 수
		pvo.setPageSize(3); // 페이지 번호
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast()); 
		
		Map<String,Object> map = empService.getEmpList(vo, svo);
		
		pvo.setTotalRecord((Long)map.get("count"));
		model.addAttribute("paging",pvo); // 이줄 지워도 페이징 처리는 가능.
		
		
		// 목록 조회
		model.addAttribute("empList", map.get("data"));
		return "empList"; 
	}
	
	@PostMapping("/insert3")   //redirect 등록 수정 삭제 할때 사용
	public String insert3(EmpVo vo, RedirectAttributes rttr) {
		System.out.println("등록:" + vo);
		rttr.addAttribute("insertResult", "성공");
		rttr.addFlashAttribute("flashResult", "한번만");
		return "redirect:empResult";
	}
	
	//등록
	@GetMapping("/insert")
	public void insert() {
		
	}	
	
	
	@PostMapping("/insert")
	public ModelAndView insert(@ModelAttribute("emp") EmpVo vo, Model model) {
		System.out.println(vo);
		empService.insertEmp(vo);
		//커맨드객체는 자동으로 model에 추가되고 view페이지에 볼수있음
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/hello");
		mv.addObject("insertResult", "success");
		//mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return mv; //페이지 명(result)
		
	}

	
		//단건조회
	@GetMapping("/info/{empId}")
	public String info(@PathVariable int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		return "empInfo"; 
	}
	//수정
	@GetMapping("/update/{empId}")
	public String update(@PathVariable int empId) {
		System.out.println(empId);
		return "index"; //리턴값이 /tamplate/index.html 을 찾아서 페이지를 넘겨준다
	}
	//삭제
	@GetMapping("/delete")
	public String delete(int employeeId, String name) {
		empService.deleteEmp(employeeId);
		return "redirect:empList"; // 삭제후 리스트로 돌아가기
	}
	
	@GetMapping("/")
	public String test() {
		return "index"; //리턴값이 /tamplate/index.html 을 찾아서 페이지를 넘겨준다
	}
	
		
}