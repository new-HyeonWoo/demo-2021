package com.example.demo.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.common.constant.auth.UserRole;
import com.example.demo.member.constant.GenderType;
import com.example.demo.member.constant.MemberStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String password;

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

	@Enumerated(EnumType.STRING)
	@Column
	private MemberStatus status;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.ROLE_NOT_PERMITTED;

	// @Temporal(TemporalType.DATE)
	// @CreationTimestamp
	// private Date createAt;
	//
	// @Temporal(TemporalType.TIMESTAMP)
	// @UpdateTimestamp
	// private Date updateAt;

}
