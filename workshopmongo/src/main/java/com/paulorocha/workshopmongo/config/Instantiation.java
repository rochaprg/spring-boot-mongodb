package com.paulorocha.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.paulorocha.workshopmongo.domain.Post;
import com.paulorocha.workshopmongo.domain.User;
import com.paulorocha.workshopmongo.dto.AuthorDTO;
import com.paulorocha.workshopmongo.repository.PostRepository;
import com.paulorocha.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("23/05/2019"), "Partiu viagem", "Vou viajar para praia !!!",new AuthorDTO (maria));
		Post post2 = new Post(null, sdf.parse("13/05/2020"), "Partiu disney", "Vou viajar para praia !!!",new AuthorDTO (maria));
		
		postRepository.save(post1);
	}

}
