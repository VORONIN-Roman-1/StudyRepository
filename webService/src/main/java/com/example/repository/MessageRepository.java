package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Message;

public interface MessageRepository extends CrudRepository<Message,Long> {
	List<Message> findByTag(String tag);
	Message findById(long id);

}
