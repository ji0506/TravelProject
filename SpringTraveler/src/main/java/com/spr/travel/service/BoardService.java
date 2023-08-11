<<<<<<< HEAD
package com.spr.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.Board;
import com.spr.travel.repository.BoardRepository;

@Service
public class BoardService {
	
	
	@Autowired
	private BoardRepository BoardRepository;

	public List<Board> getBoardList(){
		return BoardRepository.findAll();
	}
	
	public void Write(Board qvo) throws Exception {
		BoardRepository.save(qvo);
	}

	
	public List<Board> getBoardCateList(int cateNo){
		return BoardRepository.findByCateNo(cateNo);
	}

}
=======
package com.spr.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.Board;
import com.spr.travel.repository.BoardRepository;

@Service
public class BoardService {
	
	
	@Autowired
	private BoardRepository BoardRepository;

	public List<Board> getBoardList(){
		return BoardRepository.findAll();
	}
	public void Write(Board qvo) throws Exception {
		BoardRepository.save(qvo);
	}
}
>>>>>>> 박태선
