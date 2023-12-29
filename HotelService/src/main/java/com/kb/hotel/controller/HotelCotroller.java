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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kb.hotel.entities.Hotel;
import com.kb.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelCotroller {
	
	@Autowired
	HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createHotel = hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(createHotel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		Hotel hotel = hotelService.getHotel(id);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> listHotel(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.listHotels());
	}

}
