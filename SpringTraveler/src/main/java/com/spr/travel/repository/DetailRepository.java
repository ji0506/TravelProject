package com.spr.travel.repository;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.Qna;

import java.util.List;


public interface DetailRepository extends JpaRepository<ProductDetail, Integer>{

    public ProductDetail findByDetailNo(int id);
}
