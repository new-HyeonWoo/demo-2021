package com.example.demo.user.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
	ACTIVE("ACTIVE", "활성"),
	IN_ACTIVE("IN_ACTIVE", "휴먼 계정"),
	DELETE("DELETE", "삭제 계정"),
	;

	private String code;
	private String desc;

	@JsonCreator
	public static UserStatus from(String s) {
		return UserStatus.valueOf(s.toUpperCase());
	}
}
