package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// 此三合成注解，相当于@SpringBootApplication
@SpringBootConfiguration    // 指定当前是一个配置类
@EnableAutoConfiguration    //下的@AutoConfigurationPackage将主程序目录下的所有组件批量注册进容器中
// 虽然127个场景的所有自动配置启动时默认全部加载,按照条件装配规则(@Conditional),最终会按需配置
@ComponentScan("com")   // 指定包扫描范围

//@SpringBootApplication(scanBasePackages="com.example") 放大扫描包的范围，并非在主程序的目录下
//或者使用@ComponentScan(指定扫描路径)，默认指定到主程序所在的目录下,@SpringBootApplication自带此注解,所以不能同时使用
public class DemoApplication {

    public static void main(String[] args) {
//        返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);

//==============@Configuration @Bean==========================================
//        查看容器里面的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names){
//            System.out.println(name);
//        }
//        从容器中获取组件(单实例)
//        Pet tom1 = run.getBean("tom", Pet.class);
//        Pet tom2 = run.getBean("tom", Pet.class);
//        System.out.println(tom1 == tom2);

//        @Configuration(proxyBeanMethods = true),为true时时代理对象，否则普通对象
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
////        当bean为代理对象时，springboot总会检查这个组件是否在容器中
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);

//==========================@import======================================
//        获取同类型的组件,获取被@import放入容器中的组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("----------");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//        DBHelper db = run.getBean(DBHelper.class);
//        System.out.println(db);

// ===================@Conditional=======================================
//        boolean pet01 = run.containsBean("tom1");
//        System.out.println("宠物组件"+pet01);
//        boolean user01 = run.containsBean("user01");
//        System.out.println("用户组件"+user01);

//=================@ImportResource=============================
        boolean haha = run.containsBean("haha");
        System.out.println(haha);
//        AnnotationConfigApplicationContext anno = new AnnotationConfigApplicationContext(xxx.class); 从容器中获取某个类

    }
}
