package com.example.demo.member.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MemberStatus {
	ACTIVE("ACTIVE", "활성 계정"),
	IN_ACTIVE("IN_ACTIVE", "휴먼 계정"),
	DELETE("DELETE", "삭제 계정"),
	;

	private String code;
	private String desc;

	@JsonCreator
	public static MemberStatus from(String s) {
		return MemberStatus.valueOf(s.toUpperCase());
	}
}
