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
public class ProductRestServiceImpl implements ProductRestService{
    @Override
    public List<Product> getAllList() {
        return null;
    }

    @Override
    public List<Product> getListByContinent(String continent) {
        return null;
    }

    @Override
    public List<Product> getListByCity(String city) {
        return null;
    }

    @Override
    public ProductDetail getFullProductById(String id) {
        return null;
    }

    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public List<Product> getListBySearch(String country, String departure, String plan, String seat, String city, String money) {
        return null;
    }

    @Override
    public int createProduct(ProductDetail dto, String departure, String arrive) throws ParseException {
        return 0;
    }

    @Override
    public int reserve(ReservationVO rvo) {
        return 0;
    }

    @Override
    public int updateProduct(int id, ProductDetail dto, String departure, String arrive) throws ParseException {
        return 0;
    }

    @Override
    public int updateViewcnt(HttpServletRequest req, HttpServletResponse res, String id) {
        return 0;
    }

    @Override
    public ReservationVO getReservationOfMember(String member_id, String product_num) {
        return null;
    }

    @Override
    public int deleteProduct(int id) {
        return 0;
    }

    @Override
    public int createHtmlList(int id, List<String> imageNameList) {
        return 0;
    }
}
