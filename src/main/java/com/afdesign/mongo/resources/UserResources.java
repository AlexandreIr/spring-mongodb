package com.afdesign.mongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afdesign.mongo.domain.User;
import com.afdesign.mongo.dto.UserDTO;
import com.afdesign.mongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(u->new UserDTO(u)).toList();
		return ResponseEntity.ok().body(listDTO);
	}
}
