package com.example.demo.controller;

import com.example.demo.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    //注解注入和构造参数注入都行
//    @Autowired
    Car car;
    public Controller(Car car){
        this.car = car;
    }

    @GetMapping("/car")
    public Car car(){
        return car;
    }

    @GetMapping("/hello")
    public String handle01(String name){
//        HttpEncodingAutoConfiguration,因为springboot有这个自动配置,所以参数传中文不乱吗
        log.info("哈哈哈");
        return "hello, spring bootaaa" + name;
    }
}
