package com.example.questa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comments")
@Data
public class Comment {
	@Id
	Long id;
	Long postId;
	Long userId;
	
	@Lob
	@Column(columnDefinition = "text")
	String text;
}
