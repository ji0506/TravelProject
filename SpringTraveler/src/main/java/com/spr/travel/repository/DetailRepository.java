package com.spr.travel.repository;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Qna;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DetailRepository extends JpaRepository<ProductDetail, Integer>{

    public ProductDetail findByProNo(int id); // ProNo로 상세 테이블에서 찾기

    public ProductDetail findById(int id); // ID로 상세 테이블에서 찾기


}
