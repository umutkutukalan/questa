package com.example.questa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.questa.entity.User;
import com.example.questa.repository.UserRepository;
import com.example.questa.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService= userService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUser(userId);
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteOneUserById(userId);
	}
	
}
