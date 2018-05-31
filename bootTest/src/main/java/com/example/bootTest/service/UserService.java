package com.example.bootTest.service;

import java.util.List;

import com.example.bootTest.model.User;

public interface UserService {
	
	List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}
