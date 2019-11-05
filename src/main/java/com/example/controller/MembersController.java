package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Members;
import com.example.repository.BoardRepository;
import com.example.repository.MembersRepository;

@Controller
@RequestMapping("/members")
public class MembersController {

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private MembersRepository membersRepository;

	@RequestMapping(value = "/api/search/{no}", method = RequestMethod.GET)
	public ResponseEntity<Members> searchMemberByIdApi(@PathVariable("no") int no) {

		Members membersModel = membersRepository.findById(no).get();

		return new ResponseEntity<>(membersModel, HttpStatus.OK);
	}

	@RequestMapping(value = "/search/{no}", method = RequestMethod.GET)
	public String getMemberById(@PathVariable("no") int no, Model model) {

		Members membersModel = membersRepository.findById(no).get();
		model.addAttribute("member", membersModel);

		return "index";
	}

	@RequestMapping(value = "/api/search", method = RequestMethod.GET)
	public ResponseEntity<List<Members>> getMembersApi() {

		List<Members> membersList = membersRepository.findAll();

		return new ResponseEntity<>(membersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getMembers(Model model) {

		List<Members> membersList = membersRepository.findAll();
		model.addAttribute("memberList", membersList);

		return "index";
	}

	@RequestMapping(value = "/api/register", method = RequestMethod.POST, produces="application/json")
	public String addMemberApi(@RequestBody Members reqBody) {

		if ((reqBody.getEmail() == null) || (reqBody.getPwd() == null) || (reqBody.getName() == null)
				|| (reqBody.getPhone() == null) || (reqBody.getAddress() == null)) {

			return "";
		}

		try {

			membersRepository.save(Members.builder().email(reqBody.getEmail()).pwd(reqBody.getPwd())
					.name(reqBody.getName()).phone(reqBody.getPhone()).address(reqBody.getAddress()).build());

		} catch (Exception e) {

			return "";
		}

		return "boardList";
	}

	@RequestMapping(value = "/api/edit/{no}", method = RequestMethod.PUT)
	public ResponseEntity<String> editMemberApi(@PathVariable("no") int no, @RequestBody Members reqBody) {

		if ((reqBody.getEmail() == null) || (reqBody.getPwd() == null) || (reqBody.getName() == null)
				|| (reqBody.getPhone() == null) || (reqBody.getAddress() == null)) {

			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		try {

			Members membersModel = membersRepository.findById(no).get();
			membersModel.setEmail(reqBody.getEmail());
			membersModel.setPwd(reqBody.getPwd());
			membersModel.setName(reqBody.getName());
			membersModel.setPhone(reqBody.getPhone());
			membersModel.setAddress(reqBody.getAddress());
			membersRepository.save(membersModel);

		} catch (Exception e) {

			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/delete/{no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteMemberApi(@PathVariable("no") int no) {

		try {

			membersRepository.deleteById(no);

		} catch (Exception e) {

			return new ResponseEntity<>(NO_VALUE_ERROR, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	// 파일 분할 예정
	@RequestMapping(value = "/api/check/{no}", method = RequestMethod.GET)
	public boolean checkMemberApi(@PathVariable("no") int no) {

		boolean idExistCheck = membersRepository.existsById(no);

		return idExistCheck;
	}

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public String loginMemberApi(HttpServletRequest reqBody, HttpSession session, Model model) {

		Members member = membersRepository.memberLogin(reqBody.getParameter("email"), reqBody.getParameter("pwd"));

		if (member == null) {

			model.addAttribute("alt","<script>alert('로그인 실패하였습니다.');</script>");
			return "login";
		} else {

			session.setAttribute("sessionMember", member);
			model.addAttribute("alt","<script>alert('환영합니다.');</script>");
			model.addAttribute("success", "/");
			return "login";
		}
	}

	@RequestMapping(value = "/api/logout", method = RequestMethod.POST)
	public ResponseEntity<String> logoutMemberApi(HttpSession session, Model model) {

		session.removeAttribute("sessionMember");
		return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/count", method = RequestMethod.GET)
	public int countMemberApi() {

		int memberCount = membersRepository.memberCount();

		return memberCount;
	}
}
