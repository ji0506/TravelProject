package com.spr.travel.repository;

import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.Reservation;
import com.spr.travel.domain.User;
import com.spr.travel.reservation.ReservationVO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query(nativeQuery = true, value ="select * from product where pro_country = :country")
    public List<Product> findByProCountry(String country);
    @Query(nativeQuery = true, value ="select * from product where pro_departure = :departure")
    public List<Product> findByProDeparture(String departure);
    @Query(nativeQuery = true, value ="select * from product where pro_plan = :plan")
    public List<Product> findByProPlan(String plan);
    @Query(nativeQuery = true, value ="select * from product where pro_seat = :seat")
    public List<Product> findByProSeat(String seat);
    @Query(nativeQuery = true, value ="select * from product where pro_city = :city")
    public List<Product> findByProCity(String city);

    public List<Product> findByProContinent(String city);


    public Product findByProNo(int id);


    @Query(nativeQuery = true, value ="select max(pro_no) from product")
    public int findByProNo(Product proNo);
}
