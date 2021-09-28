package com.example.demo.common.service.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

	// private final JavaMailSender mailSender;

	@Override
	public void sendMail(String to, String sub, String text) {
		// SimpleMailMessage message = new SimpleMailMessage();
		// message.setTo(to);
		// message.setSubject(sub);
		// message.setText(text);
		// mailSender.send(message);
	}
}
