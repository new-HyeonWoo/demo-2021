package com.example.demo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.User;
import com.example.demo.user.domain.UserRepository;
import com.example.demo.user.dto.req.UserSaveRequestDto;
import com.example.demo.user.dto.req.UserUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Transactional
	@Override
	public User saveUser(UserSaveRequestDto requestDto) {
		log.info("user save");
		return userRepository.save(requestDto.toEntity());
	}

	@Transactional
	@Override
	public User updateUser(Long id, UserUpdateRequestDto requestDto) {
		log.info("user update");
		User user = userRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException( "해당 사용자가 없습니다. id=" + id ));

		return userRepository.save(requestDto.toEntity());
	}

	@Override
	public List<User> findUserAll() {
		log.info("find users");
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Long id) {
		log.info("find user");
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
