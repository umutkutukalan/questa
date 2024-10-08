package com.example.questa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.questa.entity.Post;
import com.example.questa.entity.User;
import com.example.questa.repository.PostRepository;
import com.example.questa.repository.UserRepository;
import com.example.questa.requests.PostCreateRequest;
import com.example.questa.requests.PostUpdateRequest;
import com.example.questa.responses.PostResponse;

@Service
public class PostService {

	PostRepository postRepository;
	UserService userService;
	
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			list = postRepository.findByUserId(userId);
		} else {
			list = postRepository.findAll();
		}
		return list.stream().map(post -> new PostResponse(post)).collect(Collectors.toList());
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePostById(PostCreateRequest newPostRequest) {
		User user = userService.getOneUser(newPostRequest.getUserId());
		if(user == null) {
			return null;
		} else {
			Post toSave = new Post();
			toSave.setId(newPostRequest.getId());
			toSave.setText(newPostRequest.getText());
			toSave.setTitle(newPostRequest.getTitle());
			toSave.setUser(user);
			return postRepository.save(toSave);
		}
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		} else {
			return null;
		}
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}

	
	
	
	
}
