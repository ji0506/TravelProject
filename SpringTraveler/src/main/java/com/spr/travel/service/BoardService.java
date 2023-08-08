package com.spr.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.Board;
import com.spr.travel.domain.Product;
import com.spr.travel.domain.User;
import com.spr.travel.repository.BoardRepository;
import com.spr.travel.repository.ProductRepository;
import com.spr.travel.repository.UserRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository ;

	

	public List<Board> getBoardList(){
		return boardRepository.findAll();
		
	}
}
