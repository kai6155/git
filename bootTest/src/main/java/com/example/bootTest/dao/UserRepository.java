package com.example.bootTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootTest.model.User;
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByName(String name);
    User findByNameOrId(String name, String id);
}
