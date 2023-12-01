package com.kb.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.hotel.entities.User;
import com.kb.hotel.exception.ResourceNotFoundException;
import com.kb.hotel.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		String uid = UUID.randomUUID().toString();
		user.setUserId(uid);
		return userRepo.save(user);
		}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found requested id:"+userId));
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User existingUser = userRepo.findById(user.getUserId()).get();
		existingUser.setAbout(user.getAbout());
		existingUser.setEmail(user.getEmail());
		existingUser.setUserName(user.getUserName());
		return userRepo.save(existingUser);
	}

	

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
	}

}
