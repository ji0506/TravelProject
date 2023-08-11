package com.spr.travel.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spr.travel.domain.User;
import com.spr.travel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products/*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private ReservationService reservationService;


    @GetMapping("/main")
    public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        List<Product> list = productService.getProductList();

        model.addAttribute("continent", "모든 상품 정보");
        listSplitAndAdd(model, list);

        return "products/index";
    }

    @GetMapping("/search")
    public String productSearch(Model model, String country, String departure, String plan, String seat, String city) {
        if (country == "" && departure == "" && plan == "" && seat == "" && city == "" ) {
            return "redirect:/products";
        }
        List<Product> list = productService.getListBySearch(country, departure, plan, seat, city);
        listSplitAndAdd(model, list);
        return "/products/index";
    }

    @GetMapping("/{id}")
    public String renderDetail(@PathVariable int id, HttpServletRequest req, HttpServletResponse res,Product product, Model model) {
        /*productService.updateViewcnt(req, res, id,product);*/
        ProductDetail detail = detailService.getFullProductById(id);
        Product product1 = productService.getProductById(id);

        if (detail == null) return "products/index";
        model.addAttribute("detail", detail);
        model.addAttribute("product", product1);

        return "products/detail";
    }

    @GetMapping("/new")
    public String renderNewForm() {
        return "products/new";
    }


    @GetMapping("/continent/{continent}")
    public String indexByContinent(@PathVariable String continent, Model model) {
        List<Product> list = productService.getListByContinent(continent);
        model.addAttribute("continent", continent);
        listSplitAndAdd(model, list);
        return "/products/index";
    }

    @GetMapping("/city/{city}")
    @ResponseBody
    public List<Product> getListByCity(@PathVariable String city, Model model) {
        List<Product> list = productService.getListByCity(city);
        return list;
    }

       @GetMapping("/{id}/reservation")
    public String renderReservationForm(@PathVariable int id, Model model, HttpSession session, RedirectAttributes rttr) {
        User loginMember = (User) session.getAttribute("userInfo");
        if (loginMember != null) {
            if (reservationService.getReservationOfMember(loginMember.getUserId(), id) != null) {
                rttr.addFlashAttribute("flashMessage", "이미 예약하신 상품입니다.");
                return "redirect:/products/" + id;
            }
        }
        model.addAttribute("product", productService.getProductById(id));
        return "/products/reserve";
    }



    private void listSplitAndAdd(Model model, List<Product> list) {
        Set<String> countrySet = new HashSet<>();
        list.stream().forEach(p -> countrySet.add(p.getProCountry()));

        Map<String, Set<String>> cityMap = new HashMap<>();
        countrySet.stream().forEach(country -> {
            Set<String> citySet = new HashSet<>();

            list.stream().filter(p -> p.getProCountry().equals(country)).forEach(p -> citySet.add(p.getProCity()));
            cityMap.put(country, citySet);
        });
        if (model.getAttribute("continent") ==null) model.addAttribute("continent", "검색 결과");
        model.addAttribute("list", list);
        model.addAttribute("countrySet", countrySet);
        model.addAttribute("cityMap", cityMap);
    }



}

