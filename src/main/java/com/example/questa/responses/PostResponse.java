package com.example.questa.responses;

import com.example.questa.entity.Post;

import lombok.Data;


@Data
public class PostResponse {
	
	Long id;
	Long userId;
	String username;
	String title;
	String text;
	
	public PostResponse(Post entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.username = entity.getUser().getUsername();
		this.title = entity.getTitle();
		this.text = entity.getText();
	}

}
