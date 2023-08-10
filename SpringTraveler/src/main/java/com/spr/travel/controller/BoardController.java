package com.spr.travel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spr.travel.domain.Qna;
import com.spr.travel.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spr.travel.domain.Board;
import com.spr.travel.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService bs;

	@Autowired
	private QnaService qs;




	@GetMapping("/faq.do")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
			
		List<Board> list = bs.getBoardList();
		
		model.addAttribute("boardlist", list);
		
		return "board/faq";
	}
	@GetMapping("/faqWrite.do")
	public String main2(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		return "board/faqWrite";
	}
	@PostMapping("/faqWrite.do")
	public String main3( @RequestParam("faq_category")int cateNo, 
			@RequestParam("faq_title")String title, @RequestParam("faq_content")String content) throws Exception {
		Board vo= new Board(title,content,cateNo);
		bs.Write(vo);
		return "redirect:/board/faq.do";
	}


	@GetMapping("/trip.do")
	public String trip( @RequestParam("menu")int menu, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Board> list = bs.getBoardCateList(menu);

		model.addAttribute("list", list);

		return "board/faq";
	}

	@GetMapping("/qna.do")
	public String qna( Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Qna> list = qs.getBoardList();
		model.addAttribute("boardlist", list);
		return "board/qna";
	}

	@GetMapping("/qnaWrite.do")
	public String qnaWrite( Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Qna> list = qs.getBoardList();
		model.addAttribute("boardlist", list);
		return "board/qnaWrite";
	}

}
