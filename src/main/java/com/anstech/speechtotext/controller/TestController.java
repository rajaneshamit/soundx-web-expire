package com.anstech.speechtotext.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/get-name")
	public String getName(String name) {
		return "Build application";
	}
}
