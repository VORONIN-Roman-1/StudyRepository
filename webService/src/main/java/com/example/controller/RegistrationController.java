package com.example.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Controller
public class RegistrationController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/registration")
	public String registration( Model model) {
		
		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(User user, Model model) {
		User userDB = userRepository.findByUsername(user.getUsername());
		if (userDB != null) {
			model.addAttribute("message", "User exists!");
			return "registration";
		}

		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		userRepository.save(user);

		return "redirect:/login";
	}

}
