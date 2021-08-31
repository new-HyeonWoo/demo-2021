package com.example.demo.member.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.MemberRepository;
import com.example.demo.member.dto.req.MemberSaveRequestDto;
import com.example.demo.member.dto.req.MemberUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final MemberRepository memberRepository;

	@Transactional
	@Override
	public Member saveUser(MemberSaveRequestDto requestDto) {
		log.info("user save");
		return memberRepository.save(requestDto.toEntity());
	}

	@Transactional
	@Override
	public Member updateUser(Long id, MemberUpdateRequestDto requestDto) {
		log.info("user update");
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException( "해당 사용자가 없습니다. id=" + id ));

		return memberRepository.save(requestDto.toEntity());
	}

	@Override
	public List<Member> findUserAll() {
		log.info("find users");
		return memberRepository.findAll();
	}

	@Override
	public Member findUserById(Long id) {
		log.info("find user");
		return null;
	}

	@Override
	public Member findUserByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
}
