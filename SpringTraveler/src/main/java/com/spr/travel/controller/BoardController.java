package com.spr.travel.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spr.travel.domain.Board;
import com.spr.travel.domain.Product;
import com.spr.travel.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/feq.do")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		List<Board> list = boardService.getBoardList();
		
		model.addAttribute("list", list);
		
		
		return "board/feq";
	}
	
	
}
