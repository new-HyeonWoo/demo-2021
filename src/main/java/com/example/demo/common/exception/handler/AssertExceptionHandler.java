package com.example.demo.common.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.exception.AssertException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class AssertExceptionHandler {

	@ExceptionHandler(AssertException.class)
	public ResponseEntity assertExceptionHandler() {
		log.info("assertExceptionHandler in");
		return null;
	}
}
