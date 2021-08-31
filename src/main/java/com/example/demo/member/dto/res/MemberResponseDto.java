package com.example.demo.member.dto.res;

import com.example.demo.member.constant.GenderType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberResponseDto {
	private long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private GenderType gender;
	private String birthday;
}
