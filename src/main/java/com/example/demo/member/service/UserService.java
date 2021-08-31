package com.example.demo.member.service;

import java.util.List;

import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.req.MemberSaveRequestDto;
import com.example.demo.member.dto.req.MemberUpdateRequestDto;

public interface UserService {

	Member saveUser(MemberSaveRequestDto requestDto);

	Member updateUser(Long id, MemberUpdateRequestDto requestDto);

	List<Member> findUserAll();

	Member findUserById(Long id);

	Member findUserByEmail(String email);

}
