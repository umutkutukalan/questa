package com.example.questa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.questa.entity.Post;
import com.example.questa.requests.PostCreateRequest;
import com.example.questa.requests.PostUpdateRequest;
import com.example.questa.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePostById(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
		return postService.updateOnePostById(postId, updatePost);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}

}
