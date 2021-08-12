package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
@Controller
//@Component
//@RestController
public class MessageController {
	
	@Autowired MessageRepository messageRepository;
	
	@GetMapping 
	public String getMessage(Map<String,Object> model) {
		Iterable<Message> messages = messageRepository.findAll();
		model.put("messages", messages);
		return "main";
	}
	@PostMapping 
	public String postMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object >model) {
		Message message = new Message (text, tag);
		messageRepository.save(message);
		Iterable<Message> messages = messageRepository.findAll();
		model.put("messages", messages);
		return "main";
	}
	@PostMapping ("filter")
	public String postFilter( @RequestParam String filter, Map<String, Object >model) {
		Iterable<Message> messages ;
		if (filter!=null && !filter.isEmpty())	messages = messageRepository.findByTag(filter);
		else messages = messageRepository.findAll();
		model.put("messages", messages);
		return "main";
	}

	
}
