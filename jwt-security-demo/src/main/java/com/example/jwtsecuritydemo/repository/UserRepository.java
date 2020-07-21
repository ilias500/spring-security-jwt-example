package com.example.jwtsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwtsecuritydemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserName(String username);

	

}
