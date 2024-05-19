package com.afdesign.mongo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.afdesign.mongo.domain.Post;
import com.afdesign.mongo.domain.User;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private LocalDate date;
	private String title;
	private String body;
	private User author;

	public PostDTO() {
	}

	public PostDTO(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.body = post.getBody();
		this.author = post.getAuthor();
		this.date = post.getDate();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		return Objects.equals(id, other.id);
	}

}
