package com.example.demo.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {


	@ApiOperation(value = "회원 단건 조회", notes = "id로 회원을 조회한다.")
	@GetMapping("/{id}")
	public String findUserById(
		@ApiParam(value = "회원ID", required = true) @PathVariable long id) {
		return null;
	}

}
