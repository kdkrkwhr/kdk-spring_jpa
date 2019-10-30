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

import com.example.model.Members;
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
	public String searchMemberById(@PathVariable("no") int no, Model model) {

		Members membersModel = membersRepository.findById(no).get();
		model.addAttribute("member", membersModel);

		return "index";
	}

	@RequestMapping(value = "/api/search", method = RequestMethod.GET)
	public ResponseEntity<List<Members>> searchMembersApi() {

		List<Members> membersList = membersRepository.findAll();

		return new ResponseEntity<>(membersList, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchMembers(Model model) {

		List<Members> membersList = membersRepository.findAll();
		model.addAttribute("memberList", membersList);

		return "index";
	}

	@RequestMapping(value = "/api/add", method = RequestMethod.POST)
	public String addMemberApi(@RequestBody Members reqBody) {

		if ((reqBody.getEmail() == null) || (reqBody.getPwd() == null) || (reqBody.getName() == null)
				|| (reqBody.getPhone() == null) || (reqBody.getAddress() == null)) {

			return NO_VALUE_ERROR;
		}

		try {

			membersRepository.save(Members.builder().email(reqBody.getEmail()).pwd(reqBody.getPwd())
					.name(reqBody.getName()).phone(reqBody.getPhone()).address(reqBody.getAddress()).build());

		} catch (Exception e) {

			return e.getMessage();
		}

		return SUCCESS;
	}

	@RequestMapping(value = "/api/edit/{no}", method = RequestMethod.PUT)
	public String editMemberApi(@PathVariable("no") int no, @RequestBody Members reqBody) {

		if ((reqBody.getEmail() == null) || (reqBody.getPwd() == null) || (reqBody.getName() == null)
				|| (reqBody.getPhone() == null) || (reqBody.getAddress() == null)) {

			return NO_VALUE_ERROR;
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

			return e.getMessage();
		}

		return SUCCESS;
	}

	@RequestMapping(value = "/api/delete/{no}", method = RequestMethod.DELETE)
	public String deleteMemberApi(@PathVariable("no") int no) {

		try {

			membersRepository.deleteById(no);

		} catch (Exception e) {

			return e.getMessage();
		}

		return SUCCESS;
	}

	// 파일 분할 예정
	@RequestMapping(value = "/api/check/{no}", method = RequestMethod.GET)
	public boolean checkMemberApi(@PathVariable("no") int no) {

		boolean idExistCheck = membersRepository.existsById(no);

		return idExistCheck;
	}

	@RequestMapping(value = "/api/count", method = RequestMethod.GET)
	public int countMemberApi() {

		int memberCount = membersRepository.memberCount();

		return memberCount;
	}
}
