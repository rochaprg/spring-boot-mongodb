package com.paulorocha.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorocha.workshopmongo.domain.Post;
import com.paulorocha.workshopmongo.repository.PostRepository;
import com.paulorocha.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	
	public List<Post> findAll (){
		List<Post> posts = repository.findAll();
		
		return posts;
	}
	
	public Post findById (String id){
		Optional<Post> post;
		
		try {
			post = repository.findById(id);
			
			if (post == null) {
				
			}
			
		}catch (Exception e) {
			throw new ObjectNotFoundException ("Objecto não identificado....");
		}
		return post.get();

		
	}
	

}
