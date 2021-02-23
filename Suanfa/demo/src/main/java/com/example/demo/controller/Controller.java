package com.example.demo.controller;

import com.example.demo.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String handle01(){
        return "hello, spring boot" + "你好";
    }
}
