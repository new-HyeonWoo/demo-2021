package com.example.demo.common.utils.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.common.utils.jwt.JwtUtil;

/**
 * token은 cookie 형태로 저장될 것.
 * Access Token과 Refresh Token을 HttpOnly로 설정을 해두고 사용한다.
 */
@Component
public class CookieUtil {

	public Cookie createCookie(String cookieName, String value){
		Cookie token = new Cookie(cookieName,value);
		token.setHttpOnly(true);
		token.setMaxAge((int)JwtUtil.TOKEN_VALIDATION_SECOND);
		token.setPath("/");
		return token;
	}

	public Cookie getCookie(HttpServletRequest req, String cookieName){
		final Cookie[] cookies = req.getCookies();
		if(cookies==null) return null;
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(cookieName))
				return cookie;
		}
		return null;
	}

}
