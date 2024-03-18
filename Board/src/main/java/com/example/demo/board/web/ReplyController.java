package com.example.demo.board.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
@RestController
public class ReplyController {
	@Autowired ReplyMapper mapper;
	//목록조회
	@RequestMapping("/ReplyMng")
	public ModelAndView ReplyMng() {
		ModelAndView mv = new ModelAndView("board/ReplyMng");
		return mv;
		
	}
	
	//데이터
	@GetMapping("/ajax/ReplyList")
	public List<ReplyVO> ReplyList(ReplyVO vo){
		return mapper.getReplyList(vo);
	}
	
	//등록
	@PostMapping("/ajax/Reply")
	public ReplyVO savereq(@RequestBody ReplyVO vo) {
		System.out.println(vo);
		mapper.insertReply(vo);
		return vo;
		
	}
}
