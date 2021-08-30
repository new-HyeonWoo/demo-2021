package com.example.demo.common.exception;

import com.example.demo.common.constant.error.ErrorCode;

import lombok.Getter;

@Getter
public class SampleException extends RuntimeException {

	private ErrorCode errorCode;

	public SampleException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}
}
