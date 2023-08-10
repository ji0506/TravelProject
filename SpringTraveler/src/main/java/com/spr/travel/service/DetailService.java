package com.spr.travel.service;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.repository.DetailRepository;
import com.spr.travel.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DetailService {

	@Autowired
	private DetailRepository detailRepository;

	public List<ProductDetail> getProductDetailList(){
		return detailRepository.findAll();
	}


	public int createProduct(ProductDetail detail){
		try {
			detailRepository.save(detail);


		}catch (Exception e){
			return -1;
		}

		return 0;
	}
	public ProductDetail getFullProductById(int id){
		return detailRepository.findByDetailNo(id);
	};

}
