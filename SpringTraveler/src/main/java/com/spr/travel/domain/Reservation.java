package com.spr.travel.domain;

import javax.persistence.Column;
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
	@Column(length=11)
	private int revNum;

	@Column(length=11)
	private int proNo;
	
	@Column(length=11)
	private String userId;
	
	@Column(length=50)
	private String revName;

	@Column(length=50)
	private String revPhone;


	@Column(length=11)
	private int revAdult;

	@Column(length=11)
	private int revMinor;


}
