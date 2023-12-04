package com.kb.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kb.hotel.entity.Rating;

public interface FeedbackRepo extends JpaRepository<Rating, String> {
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);

}
