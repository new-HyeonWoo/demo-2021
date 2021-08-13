package com.example.demo.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;
import com.example.demo.user.dto.req.UserSaveRequestDto;
import com.example.demo.user.dto.req.UserUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public User saveUser(UserSaveRequestDto requestDto) {
		return userRepository.save(requestDto.toEntity());
	}

	@Transactional
	public User updateUser(UserUpdateRequestDto requestDto) {
		return userRepository.save(requestDto.toEntity());
	}

}
