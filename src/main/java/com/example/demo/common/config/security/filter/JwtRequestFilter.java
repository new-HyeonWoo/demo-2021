package com.example.demo.common.config.security.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.common.constant.error.ErrorCode;
import com.example.demo.common.exception.SampleException;
import com.example.demo.common.config.security.CustomUserDetailService;
import com.example.demo.common.utils.cookie.CookieUtil;
import com.example.demo.common.utils.jwt.JwtUtil;
import com.example.demo.common.utils.redis.RedisUtil;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	private final CookieUtil cookieUtil;

	private final RedisUtil redisUtil;

	private final CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		final Cookie jwtToken = cookieUtil.getCookie(request, JwtUtil.ACCESS_TOKEN_NAME);
		final Cookie refreshJwtToken = cookieUtil.getCookie(request, JwtUtil.REFRESH_TOKEN_NAME);

		final String token = Optional.ofNullable(jwtToken)
			.map(Cookie::getValue).orElseThrow(() -> new SampleException(ErrorCode.FAIL_UNAUTHORIZED));

		final String refreshToken = Optional.ofNullable(refreshJwtToken)
			.map(Cookie::getValue).orElseThrow(() -> new SampleException(ErrorCode.FAIL_UNAUTHORIZED));

		String username = null;

		// AccessToken
		try {
			username = jwtUtil.getUsername(token);
			UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

			// ????????? ????????? ?????? ???????????? ????????? ??????????????? ????????? ??????????????? ????????????.
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(
					new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

				// ??????????????? ????????? ?????? ??? ??? ?????? ???????????? ??????????????? ????????????.
				// ????????? Spring Security ????????? ??????????????? ????????????.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		} catch (IllegalArgumentException e) {
			log.error("token valid error: {}", e);
			throw new RuntimeException("");
		} catch (ExpiredJwtException e) {
			log.error("token valid error: {}", e);
			throw new RuntimeException("");
		} catch (Exception e) {
			log.error("token valid error: {}", e);
			throw new RuntimeException("");
		}
		filterChain.doFilter(request, response);
	}
}
