package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList(ReplyVO vo);
	public ReplyVO read(Long rno); //댓글 읽기
	int insertReply(ReplyVO vo); //등록
}
