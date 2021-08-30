package com.example.demo.common.constant.error;

import com.example.demo.common.utils.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements ResponseCode {
	NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
	INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
	EMAIL_DUPLICATION(400,"MEMBER-ERR-400","EMAIL DUPLICATED"),
	;

	private int status;
	private String errorCode;
	private String message;

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public String getMassage() {
		return null;
	}
}