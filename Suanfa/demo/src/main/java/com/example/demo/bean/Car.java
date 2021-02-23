package com.example.demo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
// 第一种绑定配置文件方法,第二种在配置类里
//@Component//把这个组件加到容器中,才能使用springboot的功能
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
