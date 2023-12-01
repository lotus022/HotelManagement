package com.kb.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.hotel.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
