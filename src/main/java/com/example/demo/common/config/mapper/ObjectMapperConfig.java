package com.example.demo.common.config.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConfig {

	@Bean("jacksonMapper")
	public ObjectMapper objectMapper() {
		return new Jackson2ObjectMapperBuilder()
			.build();
	}
}
