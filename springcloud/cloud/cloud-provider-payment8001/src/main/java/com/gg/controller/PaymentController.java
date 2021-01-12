package com.gg.controller;

import com.gg.entities.CommonResult;
import com.gg.entities.Payment;
import com.gg.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService service;

    @PostMapping("/create")
    public CommonResult create(Payment payment){
        int result = service.create(payment);
        log.info("插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"success", result);
        }else{
            return new CommonResult(444,"fail", null);
        }
    }

    @GetMapping("/byId/{id}")
    public CommonResult byId(@PathVariable Long id){
        Payment payment = service.byId(id);
        log.info("结果："+payment);
        if(payment != null){
            return new CommonResult(200,"success", payment);
        }else{
            return new CommonResult(444,"fail", null);
        }
    }
}
