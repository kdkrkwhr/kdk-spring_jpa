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
		return "memberRegister";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String locationPage() {
		return "location";
	}

	@RequestMapping(value = "/boardRegister", method = RequestMethod.GET)
	public String boardInsertPage(Model model) {

		model.addAttribute("cn", "게시물 등록");
		model.addAttribute("btnType", "registerBtn");

		return "boardRegister";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String memberProfilePage() {
		return "memberProfile";
	}
}