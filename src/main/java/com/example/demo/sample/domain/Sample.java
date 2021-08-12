package com.example.demo.sample.domain;

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
@Table(name = "SAMPLE")
@Builder
@Entity
public class Sample {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long io;

	@Column(name="TYPE", length = 10, nullable = false)
	private String type;
}
