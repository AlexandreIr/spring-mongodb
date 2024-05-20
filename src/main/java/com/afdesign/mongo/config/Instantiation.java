package com.afdesign.mongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.afdesign.mongo.domain.Post;
import com.afdesign.mongo.domain.User;
import com.afdesign.mongo.dto.AuthorDTO;
import com.afdesign.mongo.dto.CommentDTO;
import com.afdesign.mongo.repository.PostRepository;
import com.afdesign.mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepo;

	@Override
	public void run(String... arg0) throws Exception {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		userRepository.deleteAll();
		postRepo.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, LocalDate.parse("08/06/1996", dtf), "Bom dia mundo!!", "Estou viajando",
				new AuthorDTO(bob));
		Post post2 = new Post(null, LocalDate.parse("18/02/2017", dtf), "Partiu Viagem", "Mais uma viagem linda!!",
				new AuthorDTO(alex));
		
		CommentDTO comment1 = new CommentDTO("Olá mundo", LocalDate.now(), new AuthorDTO(bob));
		CommentDTO comment2 = new CommentDTO("Adeus mundo", LocalDate.now(), new AuthorDTO(maria));

		post1.getComments().addAll(Arrays.asList(comment1,comment2));
		postRepo.saveAll(Arrays.asList(post1, post2));
		bob.getPosts().add(post1);
		alex.getPosts().add(post2);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

	}
}
