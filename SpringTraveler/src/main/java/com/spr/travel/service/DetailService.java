package com.spr.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.ProductDetail;
import com.spr.travel.repository.DetailRepository;

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
		return detailRepository.findByProNo(id);
	};

	public ProductDetail updateDetailByProNo(int id) {
		ProductDetail detail = detailRepository.findByProNo(id);
			detailRepository.save(detail);
		return detail;
	}

	public void getProductByProNo(ProductDetail detail){
		detailRepository.save(detail);

	}
	public void getListByNew (ProductDetail detail){
		detailRepository.save(detail);
	}

	public void deleteFileById(int id){
		ProductDetail detail = detailRepository.findById(id);
		detailRepository.delete(detail);
	}

}
