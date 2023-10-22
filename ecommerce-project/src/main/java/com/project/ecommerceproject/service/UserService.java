package com.project.ecommerceproject.service;

import org.springframework.stereotype.Service;

import com.project.ecommerceproject.Entity.User;
import com.project.ecommerceproject.Exception.UserException;

@Service
public interface UserService {

	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	
	
}
