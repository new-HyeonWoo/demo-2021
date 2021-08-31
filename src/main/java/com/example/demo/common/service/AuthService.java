package com.example.demo.common.service;

import com.example.demo.member.domain.Member;

public interface AuthService {

	void signUpUser(Member member);

	Member loginUser(String id, String password);

}
