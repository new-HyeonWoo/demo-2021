package com.example.demo.common.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationChecker {

	public boolean check(HttpServletRequest request, Authentication authentication) {
		return true;
	}

}
