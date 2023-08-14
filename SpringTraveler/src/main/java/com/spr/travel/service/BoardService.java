package com.spr.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.travel.domain.Board;
import com.spr.travel.domain.Notice;
import com.spr.travel.repository.BoardRepository;
import com.spr.travel.repository.NoticeRepository;

@Service
public class BoardService {
		
	@Autowired
	private BoardRepository BoardRepository;

	@Autowired
	private NoticeRepository noticeRepository;

	
	public List<Board> getBoardList(){
		return BoardRepository.findAll();
	}
	
	public void Write(Board qvo) throws Exception {
		BoardRepository.save(qvo);
	}

	
	public List<Board> getBoardCateList(int cateNo){
		return BoardRepository.findByCateNo(cateNo);
	}
	
	
	public List<Notice> getNoticeList(){
		return noticeRepository.findAll();
	}

	
	public List<Board> getNoticeCateList(int cateNo){
		return noticeRepository.findByCateNo(cateNo);
	}
	
	
	public void Write(Notice noti) throws Exception {
		noticeRepository.save(noti);
	}



}
