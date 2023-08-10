package com.spr.travel.repository;

import com.spr.travel.domain.Reservation;
import com.spr.travel.domain.User;
import com.spr.travel.reservation.ReservationVO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Integer>{

    public List<Product> findByProContinent(String continent);

    public List<Product> findByProCity(String city);

    public Product findByProNo(int id);

}
