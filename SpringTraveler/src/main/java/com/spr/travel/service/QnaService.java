package com.spr.travel.service;

import com.spr.travel.domain.Board;
import com.spr.travel.domain.Qna;
import com.spr.travel.repository.BoardRepository;
import com.spr.travel.repository.QnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
