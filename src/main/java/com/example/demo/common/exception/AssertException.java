package com.example.demo.common.exception;

public class AssertException extends RuntimeException {

	public AssertException() {
		super();
	}

	public AssertException(String message) {
		super(message);
	}

	public AssertException(Throwable ex) {
		super(ex);
	}

	public AssertException(String message, Throwable ex) {
		super(message, ex);
	}
}
