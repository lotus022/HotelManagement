package com.kb.hotel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kb.hotel.entities.Rating;
import com.kb.hotel.external.RatingService;

@SpringBootTest
class MicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	RatingService ratingService;
	
	@Test
	void createRatingTest() {
		Rating rating= Rating.builder().rating(10).feedback("This Rating from feign client").hotelId("").userId("").build();
		Rating createRating = ratingService.createRating(rating);
		System.out.println("Rating Test case created..........");
	}
}
