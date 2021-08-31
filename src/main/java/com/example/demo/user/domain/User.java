package com.example.demo.user.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.common.constant.auth.UserRole;
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
public class User implements UserDetails {

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
	private UserStatus status;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRole role = UserRole.ROLE_NOT_PERMITTED;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	// @Temporal(TemporalType.DATE)
	// @CreationTimestamp
	// private Date createAt;
	//
	// @Temporal(TemporalType.TIMESTAMP)
	// @UpdateTimestamp
	// private Date updateAt;

}
