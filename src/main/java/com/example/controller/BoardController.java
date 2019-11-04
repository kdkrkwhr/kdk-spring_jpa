package com.example.controller;

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

		Board board = boardRepository.findById(boardNo).get();
		model.addAttribute("board", board);

		return "boardDetail";
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
		} else if (boardCat.equalsIgnoreCase("reply")) {
			boardCat = "스터디 후기";
		} else if (boardCat.equalsIgnoreCase("store")) {
			boardCat = "자료실";
		}

		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCat", boardCat);

		return "boardList";
	}

	// 게시물 등록
	@RequestMapping(value = "/api/add", method = RequestMethod.POST)
	public ResponseEntity<String> addBoardApi(@RequestBody Board reqBody) {

		if (reqBody == null) {
			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		try {

			boardRepository.save(Board.builder().subject(reqBody.getSubject()).content(reqBody.getContent())
					.boardCat(reqBody.getBoardCat()).memberNo(reqBody.getMemberNo()).totalPersonCnt(reqBody.getTotalPersonCnt())
					.build());

		} catch(Exception e) {

			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/delete/{boardNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoardApi(@PathVariable int boardNo) {

		try { 

			boardRepository.deleteById(boardNo);

		} catch (Exception e) {

			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/{searchVal}", method = RequestMethod.GET)
	public String searchBoard(@PathVariable String searchVal, Model model) {

		List<Board> boardList = boardRepository.boardSearchList(searchVal);
		String boardCat = "검색 결과";
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCat", boardCat);

		return "boardList";
	}
}
