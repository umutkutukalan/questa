package com.example.questa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questa.entity.Comment;
import com.example.questa.entity.Post;
import com.example.questa.entity.User;
import com.example.questa.repository.CommentRepository;
import com.example.questa.requests.CommentCreateRequest;
import com.example.questa.requests.CommentUpdateRequest;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}
		else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else {
			return commentRepository.findAll();
		}
	}

	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneCommentById(CommentCreateRequest newCommentRequest) {
		User user = userService.getOneUser(newCommentRequest.getUserId());
		Post post = postService.getOnePostById(newCommentRequest.getPostId());
		if(user != null && post != null) {
			Comment commentSave = new Comment();
			commentSave.setId(newCommentRequest.getId());
			commentSave.setUser(user);
			commentSave.setPost(post);
			commentSave.setText(newCommentRequest.getText());
			return commentRepository.save(commentSave);
		} else {
			return null;
		}
	}

	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest updateComment) {
		
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentUpdate = comment.get();
			commentUpdate.setText(updateComment.getText());
			return commentRepository.save(commentUpdate);
		}
		return null;
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
	}

	

	

	
	
	


}
