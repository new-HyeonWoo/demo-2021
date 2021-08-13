package com.example.demo.user.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.model.response.ResultResponse;
import com.example.demo.user.dto.res.UserResponseDto;
import com.example.demo.user.dto.req.UserSaveRequestDto;
import com.example.demo.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @Api(value = "User API 컨트롤러", tags = "User API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

	private final ModelMapper modelMapper;

	private final UserService userService;

	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@ApiOperation(value = "회원정보 저장", notes = "회원정보를 저장한다.")
	@PutMapping("/user")
	public ResultResponse userSave(@RequestBody @Valid UserSaveRequestDto UserSaveRequestDto) {
		return ResultResponse.builder()
			.success(true)
			.data(modelMapper.map(userService.userSave(UserSaveRequestDto), UserResponseDto.class))
			.build();
	}
}
