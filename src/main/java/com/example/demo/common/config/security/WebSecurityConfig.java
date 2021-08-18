package com.example.demo.common.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

/**
 * Security 대한 설정
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Bean
	// public UserDetailsService userDetailsService() {
	// 	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	// 	manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
	// 	return manager;
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.headers().frameOptions().disable()	//h2-console 화면 사용위해 해당 옵션 disable
			.and()
				.authorizeRequests()
				.antMatchers("/css/**", "/images/**", "/h2-console/**").permitAll()
				.antMatchers().hasRole("")
				.anyRequest().authenticated()
			// 프론트단 vue사용하는 이유로 아래내용 사용하지 않음
			// .and()
			// 	.logout() //로그아웃
			// 		.logoutSuccessUrl("") //성공 시 이동 페이지
			// .and()
			// 	.exceptionHandling() //에러처리
			// 		.accessDeniedPage("/error") //에러 시 이동할 페이지
		;
	}

}
