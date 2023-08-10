package com.spr.travel.service;

import java.util.List;

import com.spr.travel.domain.Reservation;
import com.spr.travel.reservation.ReservationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.Product;
import com.spr.travel.repository.ProductRepository;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository ;

	public List<Product> getProductList(){
		return productRepository.findAll();
	}





	public void productSearch(String country, String departure, String plan, String seat, String city) {productRepository.findAll();}

	public List<Product> getListBySearch(String country, String departure, String plan, String seat, String city, String money)
	{return productRepository.findAll();}

	public int updateViewcnt(HttpServletRequest req, HttpServletResponse res, int id, Product product) {
		productRepository.save(product);
		return 0;
	}

	public List<Product> getListByContinent(String continent) {
		return productRepository.findByProContinent(continent);
	}

	public List<Product> getListByCity(String city){
		return productRepository.findByProCity(city);
	}


	public Product getProductById(int id){
		return productRepository.findByProNo(id);
	};



}
