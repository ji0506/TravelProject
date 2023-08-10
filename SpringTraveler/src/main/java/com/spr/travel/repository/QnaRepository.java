package com.spr.travel.repository;

import com.spr.travel.domain.Qna;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.ProductDetail;


public interface QnaRepository extends JpaRepository<Qna, Integer>{

}
