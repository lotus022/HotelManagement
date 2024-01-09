package com.kb.hotel.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("User not found server !!!!!");
	}
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
