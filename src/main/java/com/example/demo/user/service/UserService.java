package com.example.demo.user.service;

import org.springframework.stereotype.Service;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;
import com.example.demo.user.dto.req.UserSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository sampleRepository;

	public User userSave(UserSaveRequestDto requestDto) {
		return sampleRepository.save(requestDto.toEntity());
	}

}
