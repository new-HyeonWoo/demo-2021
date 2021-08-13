package com.example.demo.user.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.user.constant.GenderType;
import com.example.demo.user.dto.req.UserSaveRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
// @WebMvcTest(controllers = UserController.class)
@SpringBootTest
class UserControllerTest {

	@Autowired //스프링이 관리하는 빈 주입을 받는다.
	private MockMvc mvc; // 웹 API 테스트 시 사용(HTTP GET, POST), 스프링 MVC의 시작

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeAll
	public void before() {

	}


	@Test
	public void test() throws Exception {
		mvc.perform(get("/test"))
			.andExpect(status().isOk()) //status검증
			.andExpect(content().string("test")); //내용 검증
	}

	@Test
	public void user_save() throws Exception {
		System.out.println("******* START : user_save() **********");
		String content = objectMapper.writeValueAsString(UserSaveRequestDto.builder()
			.userId("test1")
			.name("최현우")
			.email("chlgusdn3@naver.com")
			.phoneNumber("010-2481-1015")
			.address("서울특별시")
			.gender(GenderType.MALE)
			.birthday("19901015")
			.build());

		MvcResult result = mvc.perform(put("/user")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()) //status검증
			.andReturn();

		System.out.println(result.getResponse().getContentAsString());
	}

	@Test
	public void user_update() throws Exception {
		System.out.println("******* START : user_update() **********");

	}


}