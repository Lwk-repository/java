package com.example.demo.test;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "tx")
public class Property {
    public Property(){}
    private String ta;
    private String ya;
    private Map<String, Object> ua;
}
