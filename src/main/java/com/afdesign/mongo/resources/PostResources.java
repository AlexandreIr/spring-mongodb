package com.afdesign.mongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.afdesign.mongo.domain.Post;
import com.afdesign.mongo.domain.User;
import com.afdesign.mongo.dto.PostDTO;
import com.afdesign.mongo.dto.UserDTO;
import com.afdesign.mongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		List<Post> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(new PostDTO(post));
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PostDTO postDTO) {
		Post post = service.fromDTO(postDTO);
		post = service.insert(post);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody PostDTO postDTO, @PathVariable String id) {
		Post post = service.fromDTO(postDTO);
		post.setId(id);
		post = service.update(post);
		return ResponseEntity.noContent().build();
	}
}
