package com.example.questa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.questa.entity.User;
import com.example.questa.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUsername(newUser.getUsername());
			userRepository.save(foundUser);
			return foundUser;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userRepository.deleteById(userId);
	}
	
}
