package com.example.SpringbootRestfulwebservices.service;

import java.util.List;

import com.example.SpringbootRestfulwebservices.dto.UserDto;
import com.example.SpringbootRestfulwebservices.entity.User;

	import java.util.List;
	 
	
	public interface UserService {
	    User createUser(User user);
	 
	    User getUserById(Long userId);
	 
	    List<User> getAllUsers();
	 
	     User updateUser(User user);
	 
	    void deleteUser(Long userId);
	}
	 
	


