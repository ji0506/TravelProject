package com.spr.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Reservation;


public interface ReserRepository extends JpaRepository<Reservation, Integer>{

    public Reservation findByProNo(int userID);
	
	
}
