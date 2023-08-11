package com.spr.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.Qna;


public interface DetailRepository extends JpaRepository<ProductDetail, Integer>{

	ProductDetail findByDetailNo(int id);

	
}
