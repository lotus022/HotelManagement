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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepo userRep;
	
	@Autowired
	UserService userService;


	
	@GetMapping("/hi")
	public String method() {
		return "How are you Kamal";
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		User createUser = userService.createUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}
	int retryCount=1;
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker", fallbackMethod = "ratigHotelFallback")
	//@Retry(name="ratingHotelService", fallbackMethod = "ratigHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		//logger.info("Retry count: {}", retryCount);
		System.out.println("Retry count: " + (retryCount++));
		//retryCount++;
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	public ResponseEntity<User> ratigHotelFallback(String userId, Exception ex){
		//logger.info("Fallback is executed because service is down: ", ex.getMessage());
		User user = User.builder()
			.email("dummy@gmail.com")
			.userName("Dummy")
			.about("This user is created dummy because some service is down")
			.userId("12334")
			.build();
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user){
		user.setUserId(userId);
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		userService.deleteUser(userId);
		return new ResponseEntity<String>("User deleted succesfully||| with userId"+ userId ,HttpStatus.OK);
	}
	
	
	

}
