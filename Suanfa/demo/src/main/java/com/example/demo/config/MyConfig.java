package com.example.demo.config;

import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1.配置类里面使用@bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods: 代理bean的方法，默认为true 代理对象，否则普通对象
 *      配置文件中组件不需要依赖其他组件时设置为false，启动更快
 *      相反，设置为true，保证依赖的组件是容器中的组件
 */
@Configuration(proxyBeanMethods = false)
// 告诉springboot这是一个配置类=配置文件 beans.xml
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次
     * 获取的都是之前注册容器中的单实例
     * @return
     */
    @Bean
    //给容器中添加组件，方法名=id，返回类型=组件类型，返回值=组件在容器中的实例
    public User user01() {
        return new User("hh", 18);
    }

    @Bean("pet01")
    // 组件名默认是方法名，可自定义
    public Pet pet() {
        return new Pet("haha");
    }
}
