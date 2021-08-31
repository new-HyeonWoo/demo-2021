package com.example.demo.user.service;

import java.util.List;

import com.example.demo.user.domain.User;
import com.example.demo.user.dto.req.UserSaveRequestDto;
import com.example.demo.user.dto.req.UserUpdateRequestDto;

public interface UserService {

	public User saveUser(UserSaveRequestDto requestDto);

	public User updateUser(Long id, UserUpdateRequestDto requestDto);

	public List<User> findUserAll();

	public User findUserById(Long id);

	public User findUserByEmail(String email);

}
