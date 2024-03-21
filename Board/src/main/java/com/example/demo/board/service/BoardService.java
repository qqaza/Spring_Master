package com.example.demo.board.service;

import java.util.Map;

import com.example.demo.board.BoardVO;

public interface BoardService {
	Map<String, Object> getBoardList(BoardVO vo);
	BoardVO getBoardInfo(int boardNo);
	int insertBoard(BoardVO BoardVO);
	int deleteBoard(int boardNo);
	int updateBoard(BoardVO vo);
}
