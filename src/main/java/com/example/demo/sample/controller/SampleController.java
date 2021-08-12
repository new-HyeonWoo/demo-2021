package com.example.demo.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleController {

	@GetMapping("/sample")
	public String sample() {
		return "sample";
	}
}
