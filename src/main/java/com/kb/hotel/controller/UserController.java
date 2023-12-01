package com.kb.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.hotel.entities.User;
import com.kb.hotel.repository.UserRepo;
import com.kb.hotel.services.UserService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	@Autowired
	UserRepo userRep;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hi")
	public String method() {
		return "How are you Kamal";
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User createUser = userService.createUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user){
		user.setUserId(userId);
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User deleted succesfully||| with userId"+ userId ,HttpStatus.OK);
	}
	
	
	

}
