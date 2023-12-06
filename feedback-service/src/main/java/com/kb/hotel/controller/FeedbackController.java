package com.kb.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.hotel.entity.Rating;
import com.kb.hotel.service.FeedbackService;

@RestController
@RequestMapping("/rating")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating ratig){
		Rating createFeedback = feedbackService.createFeedback(ratig);
		return ResponseEntity.status(HttpStatus.CREATED).body(createFeedback);
	}
	@GetMapping("/ratinglist")
	public ResponseEntity<List<Rating>> getListRating(){
		return ResponseEntity.status(HttpStatus.OK).body(feedbackService.getFeedback());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getListRatingByUserId(@PathVariable String userId){
		return ResponseEntity.status(HttpStatus.OK).body(feedbackService.getFeedbackByUserId(userId));
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getListRating(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(feedbackService.getFeedbackByHotelId(hotelId));
	}

}
