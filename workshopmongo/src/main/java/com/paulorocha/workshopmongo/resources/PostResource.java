package com.paulorocha.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulorocha.workshopmongo.domain.Post;
import com.paulorocha.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll (){
		
		List<Post> posts = service.findAll();
		
		return ResponseEntity.ok().body(posts);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById (@PathVariable String id){
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	

}
