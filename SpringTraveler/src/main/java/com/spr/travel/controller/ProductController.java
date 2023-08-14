package com.spr.travel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    @GetMapping("/index") // 전체 상품 보기
    public String index(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        List<Product> list = productService.getProductList();

        model.addAttribute("continent", "모든 상품 정보");
        listSplitAndAdd(model, list);

        return "products/index";
    }

    @GetMapping("/search")
    public String productSearch(Model model, String country, String departure, String plan, String seat, String city) {
        if (country == "" && departure == "" && plan == "" && seat == "" && city == "" ) {
            return "redirect:/products/index";
        }
        List<Product> list = productService.productSearch(country,departure,plan,seat,city);
        listSplitAndAdd(model, list);
        return "/products/index";
    }

    @GetMapping("/{id}") // 상세 페이지
    public String renderDetail(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse res,Product product, Model model) {
        /*productService.updateViewcnt(req, res, id,product);*/
        ProductDetail detail = detailService.getDetailById(id); // DB에 등록된 상세 테이블에서 id와 같은 값을 가진 id의 정보를 가져온다.
        Product product1 = productService.getProductById(id); // DB에 등록된 상품 테이블에서 id와 같은 값을 가진 id의 정보를 가져온다.

        if (detail == null) return "products/index"; // 상세 정보가 없으면 목록창으로 이동
        model.addAttribute("detail", detail); // 상세 테이블의 데이터를 출력
        model.addAttribute("product", product1);

        return "products/detail";
    }

    @GetMapping("/new") // 새글 작성 관리자만 사용 가능
    public String renderNewForm() {

        return "products/new";
    }

    @PostMapping("/index") // new 페이지에서 이동됨
    public String postForm(Product product,ProductDetail detail ,@RequestParam("proDepartureStr") String proDeparture,@RequestParam("proArriveStr") String proArrive) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 날짜데이터 형식 불러오기
        product.setProDeparture(formatter.parse(proDeparture)); // String 타입인 proDeparture를 Date 타입으로 변환
        product.setProArrive(formatter.parse(proArrive)); // String 타입인 proArrive를 Date 타입으로 변환

        productService.getListByNew(product); // 입력된 데이터를 상품 테이블에 저장
        detail.setProNo(product.getProNo()); // 상품 테이블에서 id를 찾아 상세 테이블에 세팅하기
        detailService.getListByNew(detail); // 입력된 데이터와 세팅된 id를 상세 테이블에 저장
        return "redirect:/products/" + product.getProNo();
    }


    @GetMapping("/continent/{continent}") // 대륙별 목록 리스트
    public String indexByContinent(@PathVariable String continent, Model model) {
        List<Product> list = productService.getListByContinent(continent); // DB에 등록된 대륙별 리스트에서 특정 대륙 데이터를 가져온다
        model.addAttribute("continent", continent); // 특정 대륙 데이터를 입력된 "continent"롤 정의 하여 검색 한다.
        listSplitAndAdd(model, list); // 리스트 출력
        return "/products/index";
    }

    @GetMapping("/city/{city}") // 도시별 목록 리스트
    @ResponseBody
    public List<Product> getListByCity(@PathVariable String city, Model model) {
        List<Product> list = productService.getListByCity(city);
        return list;
    }

       @GetMapping("/{id}/reservation") // 예약 페이지
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

    @GetMapping("/{id}/update") // 수정 페이지 관리자만 사용 가능
    public String renderUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id)); // 상품 id로 데이터를 찾기
        model.addAttribute("product_detail", detailService.updateDetailByProNo(id)); // 상품 id에 저장된 상세정보 수정
        return "products/update";
    }

    @PostMapping("/{id}/delete") // 삭제 페이지 관리자만 사용 가능
    public String deleteProduct(@PathVariable int id, RedirectAttributes rttr) throws Exception {
        String redirectUrl = "redirect:/products/"; // 삭제 완료 후 경로
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
        Set<String> countrySet = new HashSet<>(); // DB에 등록된 모든 country 데이터 수집
        list.stream().forEach(p -> countrySet.add(p.getProCountry())); // 수집된 데이트롤 이용하여 countrySet을 리스트화

        Map<String, Set<String>> cityMap = new HashMap<>(); // DB에 등록된 모든 city 데이터 수집
        countrySet.stream().forEach(country -> {
            Set<String> citySet = new HashSet<>(); // DB에 등록된 country 별로 city 데이터를 분류하고 citySet에 저장

            list.stream().filter(p -> p.getProCountry().equals(country)).forEach(p -> citySet.add(p.getProCity()));
            cityMap.put(country, citySet); // cityMa에 country를 키값으로 설정한 후 해당 country의 city목록을 값으로 입력
        });
        if (model.getAttribute("continent") ==null) model.addAttribute("continent", "검색 결과");
        model.addAttribute("list", list);
        model.addAttribute("countrySet", countrySet);
        model.addAttribute("cityMap", cityMap);
    }

}

