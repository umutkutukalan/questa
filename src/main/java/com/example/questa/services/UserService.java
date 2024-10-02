package com.example.questa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questa.entity.User;
import com.example.questa.repository.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isEmpty()) {
			User foundUser = new User();
			foundUser = user.get();
			foundUser.setUsername(newUser.getUsername());
			userRepository.save(foundUser);
			return foundUser;
		} else {
			return null;
		}
	}

	public void deleteOneUserById(Long userId) {
		userRepository.deleteById(userId);
	}
	
	
	
}
