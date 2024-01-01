package com.kb.hotel.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kb.hotel.entities.Rating;


@Service
@FeignClient(name = "FEEDBACK-SERVICE")
public interface RatingService {
	
	@PostMapping("/rating")
	Rating createRating(@RequestBody Rating rating);
	
	@GetMapping("/rating/{ratingId}")
	Rating getRating(@PathVariable String ratingId);
	
	@PutMapping("rating/{ratingId}")
	Rating updateRating(@PathVariable String ratingId, Rating rating);

	@DeleteMapping("/rating/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
	
}
