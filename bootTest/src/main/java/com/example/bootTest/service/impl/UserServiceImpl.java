package com.example.bootTest.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.bootTest.mapper.UserMapper;
import com.example.bootTest.model.User;


@Service
public class UserServiceImpl implements UserMapper{

	@Resource
	UserMapper UserMapper;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return UserMapper.getAll();
	}

	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return UserMapper.getOne(id);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		UserMapper.insert(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		UserMapper.update(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
