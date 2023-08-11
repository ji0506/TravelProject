package com.spr.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spr.travel.domain.Qna;
import com.spr.travel.repository.QnaRepository;

@Service
public class QnaService {

	@Autowired
    private QnaRepository QnaRepository;

	
    public List<Qna> getBoardList(){
        return QnaRepository.findAll();
    }
    public void Write(Qna qvo) throws Exception {
        QnaRepository.save(qvo);
    }

    //public List<Qna>  getBoardCateList(int cateNo) throws Exception {
        //return BoardRepository.findByCateNo(cateNo);
    //}
}
