package com.example.demo.common.model.response;

import com.example.demo.common.constant.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
	private int status;
	private String message;
	private String code;

	public static ErrorResponse of(ErrorCode errorCode) {
		return new ErrorResponse(
			errorCode.getStatus()
			, errorCode.getMessage()
			, errorCode.getErrorCode());
	}

}
