package com.afdesign.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afdesign.mongo.domain.Post;
import com.afdesign.mongo.domain.User;
import com.afdesign.mongo.dto.PostDTO;
import com.afdesign.mongo.dto.UserDTO;
import com.afdesign.mongo.repository.PostRepository;
import com.afdesign.mongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Post insert(Post post) {
		return repo.insert(post);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public Post update(Post post) {
		Post p = findById(post.getId());
		updateData(p, post);
		return repo.save(p);
	}
	

	private void updateData(Post p, Post post) {
		p.setTitle(post.getTitle());
		p.setBody(post.getBody());
	}

	public Post fromDTO(PostDTO postDTO) {
		return new Post(postDTO.getId(),postDTO.getDate(), postDTO.getTitle() , postDTO.getBody());
	}

}
