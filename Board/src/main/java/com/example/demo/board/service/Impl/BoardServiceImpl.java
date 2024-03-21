package com.example.demo.board.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.BoardVO;
import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override
	public Map<String, Object> getBoardList(BoardVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("data", boardMapper.getBoardList(vo));
		map.put("count", boardMapper.getCount(vo));
		return map;
	}

	@Override
	public BoardVO getBoardInfo(int boardNo) {
		BoardVO vo = new BoardVO();
		vo.setBoardNo(boardNo);
		boardMapper.updateCount(vo);
		return boardMapper.getBoardInfo(boardNo);
	}

	@Override
	public int insertBoard(BoardVO BoardVO) {
		return boardMapper.insertBoard(BoardVO);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardMapper.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return boardMapper.updateBoard(vo);
	}
	
}
