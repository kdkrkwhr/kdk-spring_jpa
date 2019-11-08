package com.example.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Board;
import com.example.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private BoardRepository boardRepository;

	// 상세 조회
	@RequestMapping(value = "/view/{boardNo}", method = RequestMethod.GET)
	public String getBoard(@PathVariable("boardNo") int boardNo, Model model) {

		Board board = boardRepository.boardDetail(boardNo);

		model.addAttribute("board", board);
		model.addAttribute("cn", "게시물 수정");
		model.addAttribute("btnType", "updateBtn");

		return "boardRegister";
	}

	// 해당 카테고리 게시물 전체 조회
	@RequestMapping(value = "/{boardCat}", method = RequestMethod.GET)
	public String getBoards(@PathVariable("boardCat") String boardCat, Model model) {

		List<Board> boardList = boardRepository.boardList(boardCat);

		if (boardCat.equalsIgnoreCase("IT")) {
			boardCat = "IT & SOFTWARE";
		} else if (boardCat.equalsIgnoreCase("ART")) {
			boardCat = "ART & DESIGN";
		} else if (boardCat.equalsIgnoreCase("BUSINESS")) {
			boardCat = "BUSINESS";
		} else if (boardCat.equalsIgnoreCase("LANGUAGE")) {
			boardCat = "LANGUAGE";
		} else if (boardCat.equalsIgnoreCase("REPLY")) {
			boardCat = "스터디 후기";
		} else if (boardCat.equalsIgnoreCase("STORE")) {
			boardCat = "자료실";
		}

		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCat", boardCat);

		return "boardList";
	}

	// 게시물 등록
	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	public ResponseEntity<String> addBoardApi(@RequestBody Board reqBody) {

		if (reqBody == null) {
			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		try {

			LocalDateTime date = LocalDateTime.now();
			boardRepository.save(
					Board.builder()
					.subject(reqBody.getSubject())
					.content(reqBody.getContent())
					.boardCat(reqBody.getBoardCat())
					.memberNo(reqBody.getMemberNo())
					.totalPersonCnt(reqBody.getTotalPersonCnt())
					.regDate(date.toString())
					.communication(reqBody.getCommunication())
					.build());

		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/delete/{boardNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoardApi(@PathVariable int boardNo) {

		try {

			boardRepository.deleteById(boardNo);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchBoard(@RequestParam String search, Model model) {

		String boardCat = "검색 결과";

		List<Board> boardList = boardRepository.boardSearchList(search);

		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCat", boardCat);

		return "boardList";
	}
}
