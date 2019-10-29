package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Test;
import com.example.repository.TestRepository;

@RestController
public class TestController {

	@Autowired
	private TestRepository testRepository;

	// 단일 조회 API
	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public Test getTestById(@PathVariable("id") int id) {

		return testRepository.findById(id).get();

	}

	// 전체 조회 API
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Test> getTests() {

		List<Test> testList = testRepository.findAll();

		return testList;
	}

	// 등록 API
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postTest(@RequestBody Test reqBody) {

		try {

			if ((reqBody.getId() == null) || (reqBody.getSubject() == null) || (reqBody.getContents() == null)) {
				return "값 을 넣어주세요.";
			}

			testRepository.save(Test.builder().id(reqBody.getId()).subject(reqBody.getSubject())
					.contents(reqBody.getContents()).build());

		} catch (Exception e) {

			return e.getMessage();

		}

		return "INSERT SUCCESS";
	}

	// 수정 API
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String updateTest(@PathVariable("id") int id, @RequestBody Test reqBody) {

		try {

			if ((reqBody.getId() == null) || (reqBody.getSubject() == null) || (reqBody.getContents() == null)) {
				return "값 을 넣어주세요.";
			}

			Test test = testRepository.findById(id).get();
			test.setId(reqBody.getId());
			test.setSubject(reqBody.getSubject());
			test.setContents(reqBody.getContents());
			testRepository.save(test);

		} catch (Exception e) {

			return e.getMessage();

		}

		return "UPDATE SUCCESS";
	}
	
	// 삭제 API
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteTestById(@PathVariable("id") int id) {

		try {

			testRepository.deleteById(id);

		} catch (Exception e) {

			return e.getMessage();

		}

		return "DELETE SUCCESS";
	}
}
