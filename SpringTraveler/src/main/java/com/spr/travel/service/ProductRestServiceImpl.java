package com.spr.travel.service;

import com.spr.travel.dao.ProductDAO;
import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.Reservation;
import com.spr.travel.reservation.ReservationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRestServiceImpl implements ProductRestService{

    private final ProductDAO dao;

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
        return dao.getFullProductById(id);
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
    public int reserve(Reservation rvo) {
        return 0;
    }

    @Override
    public int updateProduct(int id, ProductDetail dto, String departure, String arrive) throws ParseException {
        return 0;
    }

    @Override
    public int updateViewcnt(HttpServletRequest req, HttpServletResponse res, String id) {
        Cookie[] cookies = req.getCookies();
        String cookieName = "escape" + id;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieName)) {
                    return 0;
                }
            }
        }
        int result = dao.updateViewcntById(id);
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setPath(req.getContextPath() + "/products/");
        cookie.setMaxAge(60 * 60 * 24);
        res.addCookie(cookie);
        return result;
    }

    @Override
    public ReservationVO getReservationOfMember(String userId, String proNo) {
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
