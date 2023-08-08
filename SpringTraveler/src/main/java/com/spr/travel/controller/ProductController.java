package com.spr.travel.controller;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.service.ProductFileService;
import com.spr.travel.service.ProductRestService;
import com.spr.travel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/pro/*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductFileService productFileService;

    @Autowired
    private ProductRestService productRestService;


    @GetMapping("/main")
    public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        List<Product> list = productService.getProductList();

        model.addAttribute("continent", "모든 상품 정보");
        listSplitAndAdd(model, list);

        return "products/index";
    }
    @GetMapping("/{id}")
    public String renderDetail(@PathVariable String id, HttpServletRequest req, HttpServletResponse res, Model model) {
        productRestService.updateViewcnt(req, res, id);
        ProductDetail product = productRestService.getFullProductById(id);
        if (product == null) return "/products/index";
        model.addAttribute("product", product);
        return "products/detail";
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

