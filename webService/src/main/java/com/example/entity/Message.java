package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	private String text;
	@NotEmpty
	private String tag;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User author;

	public String getAuthorName() {
		if (author == null)
			return "<none>";
		return author.getUsername();
	}

	public Message() {
	}

	public Message(@NotEmpty String text, @NotEmpty String tag) {
		this.text = text;
		this.tag = tag;
	}

	public Message(@NotEmpty String text, @NotEmpty String tag, User author) {
		this.text = text;
		this.tag = tag;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
