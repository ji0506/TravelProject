package com.spr.travel.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNo;
	
	private String proContinent;
	
	private String proCountry;
	
	private String proCity;

	private String proName;

	private String proAirplane;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date proDeparture;

	@Temporal(TemporalType.TIMESTAMP)
	private Date proArrive;
	
	private int proPlan;
	
	private int proAdult;

	private int proMinor;
	
	private int proSeat;
}
