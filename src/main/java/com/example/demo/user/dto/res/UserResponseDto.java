package com.example.demo.user.dto.res;

import java.time.LocalDate;

import com.example.demo.user.constant.GenderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
