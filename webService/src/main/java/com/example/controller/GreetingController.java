package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class GreetingController {

	@GetMapping("")
	public String greeting(Map<String, Object> model) {

		return "greeting";
	}

}