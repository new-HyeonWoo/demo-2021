package com.example.demo.common.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.common.config.security.filter.JwtRequestFilter;

import lombok.RequiredArgsConstructor;

/**
 * Security 대한 설정
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.cors().and()
			.csrf().disable()
			.headers()
				.frameOptions().disable()	//h2-console 화면 사용위해 해당 옵션 disable
				.and()
			.authorizeRequests()
				.antMatchers("/css/**", "/images/**", "/h2-console/**").permitAll()
				.and()
			.exceptionHandling() //에러처리
				.accessDeniedPage("/error") //에러 시 이동할 페이지
		;

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
