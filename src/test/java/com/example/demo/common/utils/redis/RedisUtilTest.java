package com.example.demo.common.utils.redis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisUtilTest {

	@Autowired
	RedisUtil redisUtil;

	@Test
	public void testRedisUtil() {
		final String key = "refreshToken";
		final String value = "123456789";

		redisUtil.setData(key, value);
		String result = redisUtil.getData(key);

		assertEquals(value, result);
	}
}