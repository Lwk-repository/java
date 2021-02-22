package com.example.demo;

import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import com.example.demo.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

// 此三合成注解，相当于@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com")

//@SpringBootApplication(scanBasePackages="com.example") 放大扫描包的范围，并非在主程序的目录下
//或者使用@ComponentScan(指定扫描路径)，默认指定到主程序所在的目录下
public class DemoApplication {

    public static void main(String[] args) {
//        返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
//        查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names){
            System.out.println(name);
        }
//        从容器中获取组件(单实例)
        Pet pet01 = run.getBean("pet01", Pet.class);
        Pet pet02 = run.getBean("pet01", Pet.class);
        System.out.println(pet01 == pet02);

//        @Configuration(proxyBeanMethods = true),为true时时代理对象，否则普通对象
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

//        当bean为代理对象时，springboot总会检查这个组件是否在容器中
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);
    }

}
