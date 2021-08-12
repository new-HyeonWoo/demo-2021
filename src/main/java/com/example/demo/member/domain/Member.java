package com.example.demo.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 20,nullable = false)
	private String name;

	// private String password;
	//
	// private String email;
	//
	// private String phoneNumber;
	//
	// private String address;
	//
	// private String gender;
	//
	// private String birthday;

	@Builder
	public Member(String name) {
		this.name = name;
	}
}
