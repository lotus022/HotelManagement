package com.kb.hotel.services;

import java.util.List;


import com.kb.hotel.entities.User;

public interface UserService {
	User createUser(User user);
	
	User getUser(String userId);
	
	List<User> getAllUser();
	
	User updateUser(User user);
	
	void deleteUser(String userId);
	

}
