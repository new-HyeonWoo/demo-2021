package com.example.demo.common.constant;

import com.example.demo.common.utils.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorResCd implements ResponseCode {

	NOT_FOUND(404,"COMMON-ERR-404","PAGE NOT FOUND"),
	INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
	EMAIL_DUPLICATION(400,"MEMBER-ERR-400","EMAIL DUPLICATED"),
	;

	private int status;
	private String code;
	private String message;

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMassage() {
		return message;
	}
}
