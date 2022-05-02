package com.aplazo.techtest.simpleinterest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleInterestController {
	
	
	@GetMapping(path = "/simplyinterest/test")
	public String testService() {
		return "test ok!";
	}

}
