package com.spr.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.Product;
import java.util.List;



public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByProNo(int proNo);

}
