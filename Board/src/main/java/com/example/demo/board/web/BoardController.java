package com.example.demo.board.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.BoardVO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.paging;




@RestController
public class BoardController {
	@Autowired BoardService boardService;
	
	
	//목록페이지 이동
	@RequestMapping("/board/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("board/list");
		return mv;
		
	}
		
	//데이터
		@GetMapping("/ajax/boardList")
		public Map<String, Object> boardList(BoardVO vo, paging pvo) {
			vo.setStart(pvo.getFirst());
			vo.setEnd(pvo.getLast());
			Map<String, Object> map = boardService.getBoardList(vo);
			pvo.setTotalRecord((Long)map.get("count"));
			map.put("paging", pvo);
			return map;
		}
		
		// 등록 페이지이동
		@GetMapping("/board/insert")
		public ModelAndView insert() { 
			ModelAndView mv = new ModelAndView("board/insert");
			return mv;
		}
		
		// 등록처리
		@PostMapping("/ajax/board")
		public BoardVO boardInsert(@RequestBody BoardVO vo) {
			boardService.insertBoard(vo);
			return vo;
		}
		
		// 상세조회
		@GetMapping("/board/info/{boardNo}")
		public ModelAndView getBoardInfo(@PathVariable int boardNo) {
			ModelAndView mv = new ModelAndView();
			BoardVO vo = boardService.getBoardInfo(boardNo);
			mv.setViewName("board/info");
			mv.addObject("info",vo);
			return mv;
		}	
		
		// 삭제처리
		@PostMapping("/ajax/delete")
		public String delete(@RequestBody int boardNo) {
			boardService.deleteBoard(boardNo);
			return "OK";
		}	
		
		// 수정페이지 이동
		@GetMapping("/board/update/{boardNo}")
		public ModelAndView moveUpdate(@PathVariable int boardNo) {
			ModelAndView mv = new ModelAndView();
			BoardVO vo = boardService.getBoardInfo(boardNo);
			mv.setViewName("board/update");
			mv.addObject("info",vo);
			return mv;
		}	
		
		// 수정처리
		@PostMapping("/ajax/update")
		public BoardVO update(@RequestBody BoardVO vo) {
			System.out.println(vo);
			boardService.updateBoard(vo);
			return vo;
		}	
		
			
		
	
			
		
}
