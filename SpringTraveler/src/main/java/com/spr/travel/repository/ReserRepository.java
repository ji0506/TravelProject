package com.spr.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Reservation;


public interface ReserRepository extends JpaRepository<Reservation, Integer>{
<<<<<<< HEAD
	
	public List<Reservation> findByUserId(String userId);

	public Reservation findByProNo(int proNo); 
=======

    public Reservation findByProNo(int userID);
>>>>>>> 박태선
	
	
}
