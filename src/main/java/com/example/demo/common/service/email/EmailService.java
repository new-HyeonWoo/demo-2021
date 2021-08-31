package com.example.demo.common.service.email;

public interface EmailService {
	void sendMail(String to, String sub, String text);
}
