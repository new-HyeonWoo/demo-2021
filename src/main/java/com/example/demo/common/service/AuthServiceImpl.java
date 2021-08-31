package com.example.demo.common.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.common.constant.error.ErrorCode;
import com.example.demo.common.exception.SampleException;
import com.example.demo.common.utils.auth.Salt;
import com.example.demo.common.utils.auth.SaltUtil;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

	private final MemberRepository memberRepository;

	private final SaltUtil saltUtil;

	@Override
	public void signUpUser(Member member) {
		String password = member.getPassword();
		String salt = saltUtil.genSalt();
		log.info(salt);
		member.setSalt(new Salt(salt));
		member.setPassword(saltUtil.encodePassword(salt,password));
		memberRepository.save(member);
	}

	@Override
	public Member loginUser(String id, String password) {
		Member member = Optional.ofNullable(memberRepository.findByUserId(id))
			.orElseThrow(() -> new UsernameNotFoundException("not found user"));

		String salt = member.getSalt().getSalt();
		password = saltUtil.encodePassword(salt, password);

		if( member.getPassword().equals(password) ) {
			throw new SampleException(ErrorCode.INTER_SERVER_ERROR);
		}

		return member;
	}
}
