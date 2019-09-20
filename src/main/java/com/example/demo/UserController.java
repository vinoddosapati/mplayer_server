package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(UserRepository rep) {
		this.userRepository = rep;
	}
	@GetMapping("/users")
	public List<User> getUsers() {
		return (List <User>) userRepository.findAll();
	}
	
	@PostMapping("/users")
	void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
}
