package com.afdesign.mongo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.afdesign.mongo.domain.Post;
import com.afdesign.mongo.domain.User;

public class UserDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
	
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		this.setPosts(user.getPosts());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
