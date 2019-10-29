package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Members;
import com.example.repository.MembersRepository;

@RestController
public class MembersController {

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private MembersRepository membersRepository;

	@RequestMapping(value = "/members/search/{no}", method = RequestMethod.GET)
	public Members searchMemberById(@PathVariable("no") int no) {

		Members membersModel = membersRepository.findById(no).get();

		return membersModel;
	}

	@RequestMapping(value = "/members/search", method = RequestMethod.GET)
	public List<Members> searchMembers() {

		List<Members> membersList = membersRepository.findAll();

		return membersList;
	}

	@RequestMapping(value = "/members/add", method = RequestMethod.POST)
	public String addMember(@RequestBody Members reqBody) {

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

	@RequestMapping(value = "/members/edit/{no}", method = RequestMethod.PUT)
	public String editMember(@PathVariable("no") int no, @RequestBody Members reqBody) {

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

	@RequestMapping(value = "members/delete/{no}", method = RequestMethod.DELETE)
	public String deleteMember(@PathVariable("no") int no) {

		try {

			membersRepository.deleteById(no);

		} catch (Exception e) {

			return e.getMessage();
		}

		return SUCCESS;
	}
	
}
