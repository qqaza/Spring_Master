package com.example.demo.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardVO {
	
	int boardNo;
	String title;
	String content;
	String writer;
	Date writerDate;
	int clickCnt;
	String image;
	
	
}

