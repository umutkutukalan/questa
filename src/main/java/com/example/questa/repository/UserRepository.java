package com.example.questa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
