package com.example.demo.user.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GenderType {
	MALE("MALE", "남성"),
	FEMALE("FEMALE", "여성"),
	;

	private String code;
	private String desc;

	@JsonCreator
	public static GenderType from(String s) {
		return GenderType.valueOf(s.toUpperCase());
	}
}
