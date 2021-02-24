package com.example.demo.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@ToString
// 第一种绑定配置文件方法,第二种在配置类里
//@Component//把这个组件加到容器中,才能使用springboot的功能
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;
}
