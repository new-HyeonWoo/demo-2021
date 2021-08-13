package com.example.demo.user.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.user.constant.GenderType;
import com.example.demo.user.constant.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String userId;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String phoneNumber;

	@Column
	private String address;

	@Column
	private GenderType gender;

	@Column
	private String birthday;

	@Column
	private UserStatus status;
}
