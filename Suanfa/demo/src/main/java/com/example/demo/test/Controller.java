package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Stu stu;

    @Autowired
    Property property;

    @Autowired
    Service service;

    @GetMapping("/test")
    public void info(Stu stu){
        stu.info();
    }

    @GetMapping("/test1")
    public void info1(){
        stu.info();
    }

    @GetMapping("/test2")
    public void info2(){
        service.test();
    }
    @GetMapping("/test3")
    public void info3(){
        System.out.println(property);
    }
}
