package com.example;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.example.repository.TestRepository;

@SpringBootApplication
public class RestApiApplication {
	
	@Autowired
	private TestRepository testRepository;

	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
}
