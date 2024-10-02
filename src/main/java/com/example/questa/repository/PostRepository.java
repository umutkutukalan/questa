package com.example.questa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questa.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Optional<Long> userId);

}
