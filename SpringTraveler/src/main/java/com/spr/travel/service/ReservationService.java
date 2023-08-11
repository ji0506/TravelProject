package com.spr.travel.service;

import com.spr.travel.domain.Reservation;
import com.spr.travel.repository.ReserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReserRepository reserRepository;


    public Reservation getReservationOfMember(String userId, int proNo){
        return reserRepository.findByProNo(proNo);
    };
}
