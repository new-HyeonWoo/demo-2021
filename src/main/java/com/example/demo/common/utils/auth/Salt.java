package com.example.demo.common.utils.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Salt {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String salt;

	public Salt(String salt) {
		this.salt = salt;
	}
}
