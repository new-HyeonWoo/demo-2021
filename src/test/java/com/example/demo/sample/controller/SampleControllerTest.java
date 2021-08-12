package com.example.demo.sample.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SampleController.class)
class SampleControllerTest {

	@Autowired //스프링이 관리하는 빈 주입을 받는다.
	private MockMvc mvc; // 웹 API 테스트 시 사용(HTTP GET, POST), 스프링 MVC의 시작

	@Test
	public void sample_return() throws Exception {
		String hello = "sample";

		mvc.perform(get("/sample"))
			.andExpect(status().isOk()) //status검증
			.andExpect(content().string(hello)); //내용 검증
	}

}