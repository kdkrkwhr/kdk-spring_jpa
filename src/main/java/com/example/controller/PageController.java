package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Board;
import com.example.repository.BoardRepository;

@Controller
public class PageController {

	@Autowired
	private BoardRepository boardRepository;

	@RequestMapping(value = "/")
	public String mainPage(Model model) {
		List<Board> boardList = boardRepository.mainBoardList();

		List<Integer> boardCntList = boardRepository.mainBoardCnt();

		model.addAttribute("boardList", boardList);
		model.addAttribute("newBoardCnt", boardCntList.get(0));
		model.addAttribute("weekBoardCnt", boardCntList.get(1));
		model.addAttribute("totalBoardCnt", boardCntList.get(2));

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage() {
		return "register";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String locationPage() {
		return "location";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String boardInsertPage() {
		return "boardRegister";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String boardViewPage() {
		return "boardView";
	}
}