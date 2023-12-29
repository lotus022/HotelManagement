package com.kb.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.kb.hotel.entities.Hotel;
import com.kb.hotel.exception.ResourceNotFoundException;
import com.kb.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepo;
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel); 
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not present as current hotelId "+id));
	}

	@Override
	public List<Hotel> listHotels() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

}
