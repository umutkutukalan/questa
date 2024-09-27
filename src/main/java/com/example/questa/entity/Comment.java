package com.example.questa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	Long id;
	Long postId;
	Long userId;
	
	@Lob
	@Column(columnDefinition = "text")
	String text;
}
