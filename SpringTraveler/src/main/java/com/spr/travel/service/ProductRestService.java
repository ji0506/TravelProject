package com.spr.travel.service;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.reservation.ReservationVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Service
public interface ProductRestService {
    List<Product> getAllList();

    List<Product> getListByContinent(String continent);

    List<Product> getListByCity(String city);

    ProductDetail getFullProductById(String id);

    Product getProductById(String id);

    List<Product> getListBySearch(String country, String departure, String plan, String seat, String city, String money);

    int createProduct(ProductDetail dto, String departure, String arrive) throws ParseException;

    int reserve(ReservationVO rvo);

    int updateProduct(int id, ProductDetail dto, String departure, String arrive) throws ParseException;

    int updateViewcnt(HttpServletRequest req, HttpServletResponse res, String id);

    ReservationVO getReservationOfMember(String member_id, String product_num);

    int deleteProduct(int id);

    int createHtmlList(int id, List<String> imageNameList);
}
