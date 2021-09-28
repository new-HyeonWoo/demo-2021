package com.example.demo.common.utils.redis;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RedisUtil {

	private final RedisTemplate redisTemplate;

	public String getData(String key){
		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		return valueOperations.get(key);
	}

	public void setData(String key, String value){
		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key, value);
	}

	public void setDataExpire(String key, String value,long duration){
		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		Duration expireDuration = Duration.ofSeconds(duration);
		valueOperations.set(key, value, expireDuration);
	}

	public void deleteData(String key){
		redisTemplate.delete(key);
	}

}
