package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Message;
import com.example.entity.User;
import com.example.repository.MessageRepository;

@Controller
//@Component
//@RestController
@RequestMapping("/main")
public class MessageController {

	@Autowired
	MessageRepository messageRepository;

	@GetMapping
	public String getMessage(@RequestParam(required = false) String filter, Model model) {
		Iterable<Message> messages;
		if (filter != null && !filter.isEmpty())
			messages = messageRepository.findByTag(filter);
		else 
			messages = messageRepository.findAll();

		model.addAttribute("messages", messages);
		model.addAttribute("filter", filter);
		return "main";
	}

	@PostMapping
	public String postMessage(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag,
			Model model) {
		Message message = new Message(text, tag, user);
		messageRepository.save(message);
		Iterable<Message> messages = messageRepository.findAll();
		model.addAttribute("messages", messages);
		return "main";
	}
}
