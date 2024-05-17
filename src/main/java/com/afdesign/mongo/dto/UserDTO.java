package com.afdesign.mongo.dto;

import java.io.Serializable;

import com.afdesign.mongo.domain.User;

public class UserDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String namne;
	private String email;
	
	public UserDTO() {
	}
	
	public UserDTO(User user) {
		id = user.getId();
		namne = user.getName();
		email = user.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNamne() {
		return namne;
	}

	public void setNamne(String namne) {
		this.namne = namne;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
