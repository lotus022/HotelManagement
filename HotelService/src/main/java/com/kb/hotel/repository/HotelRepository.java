package com.kb.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
	

}
