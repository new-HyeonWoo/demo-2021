package com.example.demo.common.model.response;

import com.example.demo.common.constant.ErrorCode;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
	private int status;
	private String message;
	private String code;

	public ErrorResponse(ErrorCode errorCode){
		this.status = errorCode.getStatus();
		this.message = errorCode.getMessage();
		this.code = errorCode.getErrorCode();
	}

}
