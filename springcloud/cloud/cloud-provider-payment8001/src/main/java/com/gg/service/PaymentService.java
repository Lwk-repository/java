package com.gg.service;

import com.gg.dao.PaymentDao;
import com.gg.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService {
    @Resource
    private PaymentDao dao;

    public Payment byId(Long id){
        return dao.byId(id);
    }

    public int create(Payment payment){
        return dao.create(payment);
    }
}
