package com.example.demo.emp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.service.EmpService;

@SpringBootTest
public class EmpServiceTest {
	@Autowired EmpService empService;
	
	@Test
	public void 리스트페이지조회() {
		//given => 테스트할때 필요값
		EmpVo evo = new EmpVo();
		SearchVO svo = new SearchVO();
		svo.setStart(1);
		svo.setEnd(10);
		//when => 테스트할 내용
		Map<String,Object> map = empService.getEmpList(evo, svo);
		//then => 테스트 결과 검사 assret 이용해야함
		System.out.println(map.get("count"));
		assertThat(map.get("count")).isNotEqualTo(0);
	}
	
	
}
