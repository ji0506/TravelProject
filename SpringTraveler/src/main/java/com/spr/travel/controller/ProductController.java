package com.spr.travel.controller;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.ProductDetail;
import com.spr.travel.domain.Reservation;
import com.spr.travel.domain.User;
import com.spr.travel.reservation.ReservationVO;
import com.spr.travel.service.ProductFileService;
import com.spr.travel.service.ProductRestService;
import com.spr.travel.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/products/*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductRestService productRestService;

    private final ProductFileService productFileService;

    @GetMapping("/main")
    public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

        List<Product> list = productService.getProductList();

        model.addAttribute("continent", "모든 상품 정보");
        listSplitAndAdd(model, list);

        return "products/index";
    }

    @GetMapping("/new")
    public String renderNewForm() {
        return "products/new";
    }

    @SuppressWarnings("unchecked")
    @PostMapping({"/", ""})
    public String createProduct(ProductDetail dto, String departure, String arrive, MultipartFile titleImage, RedirectAttributes rttr, HttpSession session) throws Exception {
        String redirectUrl = "redirect:/products/";
        if (titleImage != null && !titleImage.isEmpty()) {
            String uploadedName = productFileService.uploadFile(titleImage);
            if (uploadedName == null || uploadedName.equals("")) {
                rttr.addFlashAttribute("flashMessage", "타이틀 이미지 등록 중 오류가 발생하였습니다.");
                return redirectUrl + "new";
            }
            dto.setDetailImage(uploadedName);
        }
        int result = productRestService.createProduct(dto, departure, arrive);
        List<String> imageNameList = (List<String>) session.getAttribute("imageNameList");
        if (result == 2) {
            rttr.addFlashAttribute("flashMessage", "성공적으로 상품 등록이 완료되었습니다.");
            if (imageNameList != null) {
                productRestService.createHtmlList(dto.getProNo(), imageNameList);
            }
        } else {
            rttr.addFlashAttribute("flashMessage", "상품 등록 중 오류가 발생하였습니다.");
            if (imageNameList != null) {
                for (String fileName : imageNameList) {
                    productFileService.deleteFile(fileName);
                }
            }
        }
        int id = dto.getProNo();
        if (id != 0) return redirectUrl + id;
        session.removeAttribute("imageNameList");
        return redirectUrl + "new";
    }


    @GetMapping("/search")
    public String productSearch(Model model, String country, String departure, String plan, String seat, String city, String money) {
        if (country == "" && departure == "" && plan == "" && seat == "" && city == "" && money == "") {
            return "redirect:/products";
        }
        List<Product> list = productRestService.getListBySearch(country, departure, plan, seat, city, money);
        listSplitAndAdd(model, list);
        return "/products/index";
    }
    @GetMapping("/{id}")
    public String renderDetail(@PathVariable String id, HttpServletRequest req, HttpServletResponse res, Model model) {
        productRestService.updateViewcnt(req, res, id);
        ProductDetail product = productRestService.getFullProductById(id);
        if (product == null) return "products/index";
        model.addAttribute("product", product);
        return "/products/detail";
    }

   /* @PostMapping("/{id}")
    public String reservation(HttpSession session, @PathVariable int id, Reservation rvo, RedirectAttributes rttr) {
        User loginUser = (User) session.getAttribute("userInfo");
        if (loginUser != null && !loginUser.getUserId().equals(rvo.getUserId())) {
            rttr.addFlashAttribute("flashMessage", "비정상적인 접근입니다.");
            return "redirect:/";
        }
        rvo.setProduct_num(id);
        int result = productRestService.reserve(rvo);
        if (result > 0) {
            rttr.addFlashAttribute("flashMessage", "예약이 완료되었습니다.");
            if (loginUser != null) {
                return "redirect:/member/myPage";
            } else {
                rttr.addFlashAttribute("revName;", rvo.getRevName());
                rttr.addFlashAttribute("rev_email", rvo.getRev_email());
                rttr.addFlashAttribute("rev_phone", rvo.getRevPhone());
                return "redirect:/member/rev_check";
            }
        } else {
            rttr.addFlashAttribute("flashMessage", "예약 중 오류가 발생하였습니다.");
            return "redirect:/products/reserve";
        }
    }*/


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

