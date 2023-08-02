package com.spr.travel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
public class MainController {

	
	@GetMapping("/main.do")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

		return "main/main";
	}
}
