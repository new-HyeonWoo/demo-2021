package com.example.demo.user.dto.res;

import com.example.demo.user.constant.GenderType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
	private long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private GenderType gender;
	private String birthday;
}
