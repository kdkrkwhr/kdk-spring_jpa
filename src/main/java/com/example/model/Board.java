package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNo;

	private String subject;
	
	@Column(length = 100000000)
	private String content;

	private String boardCat;
	private int memberNo;
	private int totalPersonCnt;
	private String regDate;

	@Builder
	public Board(String subject, String content, String boardCat, int memberNo, int totalPersonCnt, String regDate) {

		this.subject = subject;
		this.content = content;
		this.boardCat = boardCat;
		this.memberNo = memberNo;
		this.totalPersonCnt = totalPersonCnt;
		this.regDate = regDate;
	}
}
