package com.afdesign.mongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afdesign.mongo.domain.User;
import com.afdesign.mongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; 
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
