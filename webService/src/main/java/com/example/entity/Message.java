package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String text;
	@NotEmpty
	private String tag;
	
	public Message() {
	}

	public Message(@NotEmpty String text, @NotEmpty String tag) {
		this.text = text;
		this.tag = tag;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
