package com.spr.travel.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spr.travel.domain.Product;
import com.spr.travel.domain.Reservation;
import com.spr.travel.domain.User;
import com.spr.travel.service.UserService;


@Controller
@RequestMapping("/member/*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/main.do")
    public String list() {
        return "member/login";
    }


    // (회원)마이페이지 출력-예약내역
    @GetMapping("/myPage")
    @Transactional
    public String myPage(User user, HttpServletRequest request, HttpSession session, Model model) throws Exception{
        user = (User) session.getAttribute("user");

//		List<Reservation> rev = userService.checkRev(user);
//		List<Product> pList = userService.findProductList(rev);


        //model.addAttribute("product", pList);


        return "member/info";
    }

    @RequestMapping("/logout.do")
    public String logout(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/main/main.do";
    }

}
