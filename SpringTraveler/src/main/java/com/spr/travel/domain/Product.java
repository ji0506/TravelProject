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

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getProContinent() {
		return proContinent;
	}

	public void setProContinent(String proContinent) {
		this.proContinent = proContinent;
	}

	public String getProCountry() {
		return proCountry;
	}

	public void setProCountry(String proCountry) {
		this.proCountry = proCountry;
	}

	public String getProCity() {
		return proCity;
	}

	public void setProCity(String proCity) {
		this.proCity = proCity;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProAirplane() {
		return proAirplane;
	}

	public void setProAirplane(String proAirplane) {
		this.proAirplane = proAirplane;
	}

	public Date getProDeparture() {
		return proDeparture;
	}

	public void setProDeparture(Date proDeparture) {
		this.proDeparture = proDeparture;
	}

	public Date getProArrive() {
		return proArrive;
	}

	public void setProArrive(Date proArrive) {
		this.proArrive = proArrive;
	}

	public int getProPlan() {
		return proPlan;
	}

	public void setProPlan(int proPlan) {
		this.proPlan = proPlan;
	}

	public int getProAdult() {
		return proAdult;
	}

	public void setProAdult(int proAdult) {
		this.proAdult = proAdult;
	}

	public int getProMinor() {
		return proMinor;
	}

	public void setProMinor(int proMinor) {
		this.proMinor = proMinor;
	}

	public int getProSeat() {
		return proSeat;
	}

	public void setProSeat(int proSeat) {
		this.proSeat = proSeat;
	}
}
