package com.example.demo.emp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.ex.mapper.service.SampleService;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class SampleServiceTest {
	@Setter(onMethod_ = @ Autowired)
	private SampleService service;
	
	@Test
	public void 트랜잭션() {
		String str = "테스트입니다.";
		log.info("문자열길이:"+str.getBytes().length);
		service.addData(str);
	}
}
