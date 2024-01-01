package com.kb.hotel.service;

import java.util.List;

import com.kb.hotel.entities.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	Hotel getHotel(String id);
	
	List<Hotel> listHotels();

}
