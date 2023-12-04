package com.kb.hotel.service;

import java.util.List;

import com.kb.hotel.entity.Rating;

public interface FeedbackService {
	
	Rating createFeedback(Rating rating);
	
	List<Rating> getFeedback();
	
	List<Rating> getFeedbackByUserId(String userId);
	
	List<Rating> getFeedbackByHotelId(String hotelId);

}
