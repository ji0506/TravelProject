package com.spr.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.User;
import com.spr.travel.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	
	public User getLoginUser(String id) {
		return userRepository.findById(id).get();
	}
	
}
