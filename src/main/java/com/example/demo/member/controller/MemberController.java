package com.example.demo.member.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.model.response.ResultResponse;
import com.example.demo.member.dto.req.MemberSaveRequestDto;
import com.example.demo.member.dto.req.MemberUpdateRequestDto;
import com.example.demo.member.dto.res.MemberResponseDto;
import com.example.demo.member.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @Api(value = "User API 컨트롤러", tags = "User API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

	private final ModelMapper modelMapper;

	private final UserService userService;

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@ApiOperation(value = "회원정보 저장", notes = "회원정보를 저장한다.")
	@PostMapping("/user")
	public ResultResponse saveUser(@RequestBody @Valid MemberSaveRequestDto requestDto) {
		return ResultResponse.builder()
			.success(true)
			.data(modelMapper.map(userService.saveUser(requestDto), MemberResponseDto.class))
			.build();
	}

	@ApiOperation(value = "회원정보 수정", notes = "회원정보를 수정한다.")
	@PutMapping("/user/{id}")
	public ResultResponse updateUser(
		@ApiParam(value = "사용자 고유번호", required = true)
		@PathVariable Long id,
		@RequestBody @Valid MemberUpdateRequestDto requestDto) {
		return ResultResponse.builder()
			.success(true)
			.data(modelMapper.map(userService.updateUser(id, requestDto), MemberResponseDto.class))
			.build();
	}

	@ApiOperation(value = "회원 전체 조회", notes = "회원 전체 정보를 조회한다.")
	@GetMapping("/users")
	public ResultResponse findUserAll() {
		return ResultResponse.builder()
			.success(true)
			.data(modelMapper.map(userService.findUserAll(), MemberResponseDto.class))
			.build();
	}

	@ApiOperation(value = "회원 정보 조회", notes = "회원 고유번호로 회원정보를 조회한다.")
	@GetMapping("user/{id}")
	public ResultResponse findUserById(
		@ApiParam(value = "사용자 고유번호", required = true)
		@PathVariable Long id) {
		return ResultResponse.builder()
			.success(true)
			.data(modelMapper.map(userService.findUserById(id), MemberResponseDto.class))
			.build();
	}
}
