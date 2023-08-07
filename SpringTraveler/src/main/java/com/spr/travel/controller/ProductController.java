package com.spr.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pro/*")
public class ProductController {


    @GetMapping({"/", ""})
    public String renderIndex(Model model) {
/*        List<ProductVO> list = ps.getAllList();
        model.addAttribute("continent", "모든 상품 정보");
        listSplitAndAdd(model, list);*/
        return "products/index";
    }
	
	
}
