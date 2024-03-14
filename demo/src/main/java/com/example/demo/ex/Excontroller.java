package com.example.demo.ex;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.EmpVo;

@Controller
public class Excontroller { //체크박스 1개씩
	@RequestMapping("/ex2")
	public String ex2(EX1VO vo) {
		System.out.println(vo);
		return "index";
	}
	
	@RequestMapping("/ex3") //다중 체크박스
	public String ex3(ListCodeVO vo) {
		System.out.println(vo);
		return "index";
	}
	
	@RequestMapping("/ex4/{username}/{userage}") // 유저 이름과 나이 같이 나타내기
	public String ex4(@PathVariable String username, @PathVariable(name = "userage") int age) {
		System.out.println("username:" + username);
		System.out.println("age:" + age);
		return "index";
	}
	
	@RequestMapping("/ex5") //커맨드객체 없이 파라미터 localhost:8081/ex4?username = xxx&age=2
	public String ex5(String username, @RequestParam(name = "userage", required = false, defaultValue = "10") Integer age) { // integer 넣고 나이 입력안하면 나이 입력안해서 null 로 표기
		System.out.println("username:" + username);
		System.out.println("age:" + age);
		return "index";
	}
	
//	@RequestMapping("/ex6")
//	public String ex6(EmpVo vo, MultipartFile[] photos)
//		System.out.println(vo);
//		if(photos != null) {
//		for(MultipartFile photo : photos) {
//		
//		}
//		//파일저장
//		try {
//			photo.transferTo(new File("d:/upload", photo.getOriginalFilename()));
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		}
//	}
//		System.out.println("파일명:" + photo.getOriginalFilename());
//		System.out.println("파일zmrl:" + photo.getSize());
//		return "index";
//	}


}
