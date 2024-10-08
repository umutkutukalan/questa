package com.example.questa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questa.entity.Like;
import com.example.questa.entity.Post;
import com.example.questa.entity.User;
import com.example.questa.repository.LikeRepository;
import com.example.questa.requests.LikeCreateRequest;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;
	
	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId, postId);
		} else if(userId.isPresent()) {
			return likeRepository.findByUserId(userId);
		} else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId);
		} else {
			return likeRepository.findAll();
		}
	}

	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public Like createOneLike(LikeCreateRequest newLikeRequest) {
		User user = userService.getOneUser(newLikeRequest.getUserId());
		Post post = postService.getOnePostById(newLikeRequest.getPostId());
		if(user != null && post != null) {
			Like likeSave = new Like();
			likeSave.setId(newLikeRequest.getId());
			likeSave.setUser(user);
			likeSave.setPost(post);
			return likeRepository.save(likeSave);
		} else {
			return null;
		}
	}

	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
	}

	

	
	
	

}
