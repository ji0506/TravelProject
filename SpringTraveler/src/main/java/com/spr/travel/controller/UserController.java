package com.spr.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class UserController {

	
	@RequestMapping("/main.do")
	public String list() {	
		return "member/login";
	}
	
	
}
