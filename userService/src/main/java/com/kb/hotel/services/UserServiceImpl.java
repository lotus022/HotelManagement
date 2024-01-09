package com.kb.hotel.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kb.hotel.entities.Hotel;
import com.kb.hotel.entities.Rating;
import com.kb.hotel.entities.User;
import com.kb.hotel.exception.ResourceNotFoundException;
import com.kb.hotel.external.HotelService;
import com.kb.hotel.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelService;

	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	

	
	@Override
	public User createUser(User user) {
		String uid = UUID.randomUUID().toString();
		user.setUserId(uid);
		return userRepo.save(user);
		}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found requested id:"+userId));
		Rating[] rateList = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+userId, Rating[].class);
		logger.info("{}", rateList);
		List<Rating> list = Arrays.stream(rateList).toList();
		List<Rating> collect = list.stream()
				.map((rating) ->{
				//	ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class);
				//	Hotel hotel = forEntity.getBody();
					//System.out.println(hotel.toString());
					//logger.info("Response status code: {}", forEntity);
					Hotel hotel=hotelService.getHotel(rating.getHotelId());
					rating.setHotel(hotel);
					return rating;
				} ).collect(Collectors.toList());
		
		user.setRatings(collect);
		return user;
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
