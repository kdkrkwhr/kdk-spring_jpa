package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Test;
import com.example.repository.TestRepository;

@RestController
public class TestController {

	static final String SUCCESS = "SUCCESS";
	static final String NO_VALUE_ERROR = "NO VALUE";

	@Autowired
	private TestRepository testRepository;

	// 특정 조회 API
	@RequestMapping(value = "/test/search/{seq}", method = RequestMethod.GET)
	public Test getTestById(@PathVariable("seq") int seq) {

		Test testModel = testRepository.findById(seq).get();

		return testModel;
	}

	// 전체 조회 API
	@RequestMapping(value = "/test/search", method = RequestMethod.GET)
	public List<Test> getTests() {

		List<Test> testList = testRepository.findAll();

		return testList;
	}

	// 등록 API
	@RequestMapping(value = "/test/add", method = RequestMethod.POST)
	public String postTest(@RequestBody Test reqBody) {
		
		if ((reqBody.getId() == null) || (reqBody.getSubject() == null) || (reqBody.getContents() == null)) {
			return NO_VALUE_ERROR;
		}

		try {

			testRepository.save(Test.builder().id(reqBody.getId()).subject(reqBody.getSubject())
					.contents(reqBody.getContents()).build());

		} catch (Exception e) {

			return e.getMessage();
		}

		return SUCCESS;
	}

	// 수정 API
	@RequestMapping(value = "/test/edit/{seq}", method = RequestMethod.PUT)
	public String updateTest(@PathVariable("seq") int seq, @RequestBody Test reqBody) {
		
		if ((reqBody.getId() == null) || (reqBody.getSubject() == null) || (reqBody.getContents() == null)) {
			return NO_VALUE_ERROR;
		}

		try {

			Test testModel = testRepository.findById(seq).get();
			testModel.setId(reqBody.getId());
			testModel.setSubject(reqBody.getSubject());
			testModel.setContents(reqBody.getContents());
			testRepository.save(testModel);

		} catch (Exception e) {

			return e.getMessage();
		}

		return SUCCESS;
	}

	// 삭제 API
	@RequestMapping(value = "/test/delete/{seq}", method = RequestMethod.DELETE)
	public String deleteTestById(@PathVariable("seq") int seq) {

		try {

			testRepository.deleteById(seq);

		} catch (Exception e) {

			return e.getMessage();
		}

		return SUCCESS;
	}

	// 데이터 카운트 API 
	@RequestMapping(value = "/test/cnt", method = RequestMethod.GET)
	public int countTest() {

		int dataCnt = testRepository.dataCnt();

		return dataCnt;
	}

	// 로그인 API
	@RequestMapping(value = "/test/login", method = RequestMethod.POST)
	public String loginTest(@RequestBody Test reqBody) {
		String message = "";

		int loginConfirm = testRepository.loginConfirm();
		if (0 < loginConfirm) {
			message = "LOGIN SUCCESS";
		} else {
			message = "LOGIN FAIL";
		}

		return message;
	}
}
