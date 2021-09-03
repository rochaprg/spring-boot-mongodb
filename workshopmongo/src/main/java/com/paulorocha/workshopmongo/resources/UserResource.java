package com.paulorocha.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulorocha.workshopmongo.domain.User;
import com.paulorocha.workshopmongo.services.UserService;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll (){
		
		List<User> listUser = service.findAll();
		
		return ResponseEntity.ok(listUser);
	}

}
