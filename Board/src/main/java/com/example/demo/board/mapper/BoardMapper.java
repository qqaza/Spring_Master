package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.board.BoardVO;
import com.example.demo.emp.EmpVo;
import com.example.demo.emp.SearchVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoardInfo(int boardNo);
	int insertBoard(BoardVO BoardVO);
	int deleteBoard(int boardNo);
	int updateBoard(BoardVO vo);
	long getCount(BoardVO vo);
	int updateCount(BoardVO vo);
}
