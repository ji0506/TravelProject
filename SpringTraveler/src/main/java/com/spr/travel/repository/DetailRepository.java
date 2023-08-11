package com.spr.travel.repository;

<<<<<<< HEAD
=======
import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
>>>>>>> 박태선
import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.Qna;

<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 박태선

public interface DetailRepository extends JpaRepository<ProductDetail, Integer>{

<<<<<<< HEAD
	ProductDetail findByDetailNo(int id);
=======
public interface DetailRepository extends JpaRepository<ProductDetail, Integer>{
>>>>>>> 박태선

    public ProductDetail findByDetailNo(int id);
}
