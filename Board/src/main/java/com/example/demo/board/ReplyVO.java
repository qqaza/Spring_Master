package com.example.demo.board;

import java.util.Date;

import lombok.Data;
@Data
public class ReplyVO {
	private Long rno;
	private Long board_no;
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
