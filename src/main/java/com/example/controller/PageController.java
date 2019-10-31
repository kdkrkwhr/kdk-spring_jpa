package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String locationPage() {
		return "location";
	}

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String boardPage() {
		return "boardList";
	}
}