package com.example.demo.common.utils.redis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTest {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void testStringRedisTemplate() {
		final String key = "refreshToken";
		final String value = "123456789";
		final ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();

		// redis set
		stringStringValueOperations.set(key, value);
		final String result = stringStringValueOperations.get(key);

		assertEquals(value, result);
	}

}