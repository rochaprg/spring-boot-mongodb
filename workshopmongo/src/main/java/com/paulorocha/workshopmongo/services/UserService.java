package com.paulorocha.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulorocha.workshopmongo.domain.User;
import com.paulorocha.workshopmongo.dto.UserDTO;
import com.paulorocha.workshopmongo.repository.UserRepository;
import com.paulorocha.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById (String id)
	{
		Optional<User> user;
		try {
			user = repository.findById(id);
		
			if (user.get() == null) {
				
			}
		}catch (Exception e) {
			throw new ObjectNotFoundException("Objecto nao encontrado");
		}
		return user.get();
	}
	
	public User insert (User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO (UserDTO objDTO) {
		
		return new User (objDTO.getId(),objDTO.getName(),objDTO.getEmail());
	}
}
