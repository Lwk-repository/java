package com.example.demo.test;

@org.springframework.stereotype.Service
public class Service {
    private Property property;

    public Service(Property property) {
        this.property = property;
    }

    public void test() {
        System.out.println(property);
    }
}
