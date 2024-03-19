package com.example.demo.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.BoardVO;
import com.example.demo.board.BsearchVO;
import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.common.paging.Paging;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Controller
public class BoardController {
	final BoardMapper mapper;
	
	
	//목록페이지 이동
	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("board/list");
		return mv;
		
	}
		
	//데이터
		@GetMapping("/ajax/boardlist")
		public List<BoardVO> boardlist(BoardVO vo){
			return mapper.getboardlist(vo);
		}
		
			
		
	
			
		
}
