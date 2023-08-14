package com.spr.travel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.SearchForm;
import com.spr.travel.domain.User;
import com.spr.travel.service.DetailService;
import com.spr.travel.service.ProductService;
import com.spr.travel.service.ReservationService;

@Controller
@RequestMapping("/products/*")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private ReservationService reservationService;


    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        List<Product> list = productService.getProductList();

        model.addAttribute("continent", "모든 상품 정보");
        listSplitAndAdd(model, list);

        return "products/index";
    }

    @GetMapping("/search")
    public String productSearch(Model model, SearchForm search) {
        if (search.getCountry() == "" && search.getDeparture() == "" && search.getPlan() == "" && search.getSeat() == "" && search.getCity() == "" ) {
            return "redirect:/products/index";
        }
        List<Product> list = productService.productSearch(search);
        
        model.addAttribute("list", list);

        listSplitAndAdd(model, list);
        return "/products/index";
    }

    @GetMapping("/{id}")
    public String renderDetail(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res,Product product, Model model) {
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

    @PostMapping("/index")
    public String postForm(Product product,ProductDetail detail ,@RequestParam("proDepartureStr") String proDeparture,@RequestParam("proArriveStr") String proArrive) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        product.setProDeparture(formatter.parse(proDeparture));
        product.setProArrive(formatter.parse(proArrive));

//        productService.getProNo(product);
        productService.getListByNew(product);
        detail.setProNo(product.getProNo());
        detailService.getListByNew(detail);
        //        detailService.getProductByProNo(detail);
        return "redirect:/products/" + product.getProNo();
    }


    @GetMapping("/continent/{continent}")
    public String indexByContinent(@PathVariable String continent, Model model) {
        List<Product> list = productService.getListByContinent(continent);
        model.addAttribute("continent", continent);
        model.addAttribute("list", list);
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
        User loginMember = (User) session.getAttribute("user");/*"userInfo"*/
        if (loginMember != null) {
            if (reservationService.getReservationOfMember(loginMember.getUserId(), id) != null) {
                rttr.addFlashAttribute("flashMessage", "이미 예약하신 상품입니다.");
                return "redirect:/products/" + id;
            }
        }
        model.addAttribute("product", productService.getProductById(id));
        return "/products/reserve";
    }

    @GetMapping("/{id}/update")
    public String renderUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("product_detail", detailService.updateDetailByProNo(id));
        return "products/update";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, RedirectAttributes rttr) throws Exception {
        String redirectUrl = "redirect:/products/";
        detailService.deleteFileById(id);
        int result = productService.deleteProduct(id);
        if (result > 0) {
            rttr.addFlashAttribute("flashMessage", "정상적으로 삭제가 완료되었습니다.");
            return redirectUrl;
        } else {
            rttr.addFlashAttribute("flashMessage", "삭제 중 오류가 발생하였습니다.");
            return redirectUrl + id;
        }
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
        model.addAttribute("countrySet", countrySet);
        model.addAttribute("cityMap", cityMap);
    }

}

