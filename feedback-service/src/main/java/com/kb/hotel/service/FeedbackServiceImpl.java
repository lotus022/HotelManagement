package com.kb.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kb.hotel.entity.Rating;
import com.kb.hotel.repository.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepo feedRepo;
	@Override
	public Rating createFeedback(Rating rating) {
		// TODO Auto-generated method stub
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		
		return feedRepo.save(rating);
	}

	@Override
	public List<Rating> getFeedback() {
		// TODO Auto-generated method stub
		return feedRepo.findAll();
	}

	@Override
	public List<Rating> getFeedbackByUserId(String userId) {
		// TODO Auto-generated method stub
		return feedRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getFeedbackByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return feedRepo.findByHotelId(hotelId);
	}
	

}
