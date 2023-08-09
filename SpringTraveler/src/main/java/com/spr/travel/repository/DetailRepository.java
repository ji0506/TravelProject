package com.spr.travel.repository;

import com.spr.travel.domain.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;


public interface DetailRepository extends JpaRepository<Qna, Integer>{

	
}
