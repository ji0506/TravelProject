package com.spr.travel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int revNum;
	
	private String userId;
	
	private String revName;

	private String revPhone;

	private int proNum;

	private int revAdult;

	private int revMinor;


}
