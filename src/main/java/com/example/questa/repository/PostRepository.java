package com.example.questa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questa.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
