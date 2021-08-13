package com.example.demo.user.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class SampleControllerTest {

	@Autowired //스프링이 관리하는 빈 주입을 받는다.
	private MockMvc mvc; // 웹 API 테스트 시 사용(HTTP GET, POST), 스프링 MVC의 시작

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void sample_return() throws Exception {

	}

}