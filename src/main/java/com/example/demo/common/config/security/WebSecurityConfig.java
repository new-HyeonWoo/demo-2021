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
			.csrf()
				.disable()
			.headers()
				.frameOptions().disable()	//h2-console 화면 사용위해 해당 옵션 disable
				.and()
			.authorizeRequests()
				.antMatchers("/css/**", "/images/**", "/h2-console/**").permitAll()
				.anyRequest().access("@authorizationChecker.check(request, authentication)")
				// .antMatchers().hasRole("")
				// .anyRequest().authenticated()
				.and()
			/*.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout() //로그아웃
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("") //성공 시 이동 페이지
				.permitAll()
				.and()*/
			.exceptionHandling() //에러처리
				.accessDeniedPage("/error") //에러 시 이동할 페이지
		;
	}
}
