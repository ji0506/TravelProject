package com.spr.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Product;
import org.springframework.web.multipart.MultipartFile;


public interface ProductRepository extends JpaRepository<Product, Integer>{



}
