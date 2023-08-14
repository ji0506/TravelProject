package com.spr.travel.service;

import java.util.Date;
import java.util.List;

import com.spr.travel.domain.ProductDetail;
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

	public List<Product> productSearch(String country, String departure, String plan, String seat, String city)
	{return null;
/*		productRepository.findByProCountry(country),
		productRepository.findByProDeparture(departure),
		productRepository.findByProPlan(plan),
		productRepository.findByProSeat(seat),
		productRepository.findByProCity(city);*/
	}

	public List<Product> getListBySearch(String country, String departure, String plan, String seat, String city)
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

	public void getListByNew (Product product){
		productRepository.save(product);
	}


	public int getProNo(Product proNo){
		return productRepository.findByProNo(proNo);
	}

	public int deleteProduct(int id){
			productRepository.deleteById(id);
		return 1;
	}


}
