package com.example.demo.common.utils.redis;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedisData implements Serializable {
	private static final long serialVersionUID = 1L;
	private String refreshToken;
	private String etc;
}
