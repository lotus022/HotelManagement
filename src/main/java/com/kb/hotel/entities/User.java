package com.kb.hotel.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_table")
public class User {
	@Id
	@Column(name = "uid")
	private String userId;
	@Column(name = "user_name",length = 15)
	private String userName;
	private String email;
	private String about;
	
	@Transient
	private List<Rating> ratings= new ArrayList<>();
	

}
