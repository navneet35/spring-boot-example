package com.springboot.example.service.impl;

import org.springframework.stereotype.Service;

import com.springboot.example.exception.LoginException;
import com.springboot.example.models.User;
import com.springboot.example.service.UserService;
import com.springboot.example.utils.LoginRequired;


@Service
public class UserServiceImpl implements UserService{

	@Override
	@LoginRequired(username = "navneet")
	public User getUser() {
		User user = new User();
		user.setId("1");
		user.setName("Navneet");
		user.setPassword("Test");
		throw new LoginException("Test login exception");
//		return user;
	}
	
}
