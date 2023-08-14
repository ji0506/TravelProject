package com.spr.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.ProductDetail;


public interface DetailRepository extends JpaRepository<ProductDetail, Integer>{

    public ProductDetail findByProNo(int id);

    public ProductDetail findById(int id);


}
