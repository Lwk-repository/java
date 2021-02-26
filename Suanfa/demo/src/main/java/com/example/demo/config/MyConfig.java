package com.example.demo.config;

import ch.qos.logback.core.db.DBHelper;
import com.example.demo.bean.Car;
import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 1.配置类里面使用@bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods: 代理bean的方法,默认为true,为true时此类为代理对象，否则普通对象
 *      full(proxyBeanMethods=true)[保证每个@bean方法被调用多少次返回的组件都是单实例的]
 *      lite(proxyBeanMethods=false)[每个@bean方法被调用多少次返回的组件都是新创建的]
 *      配置文件中组件不需要依赖其他组件时设置为false，启动更快
 *      相反，设置为true，保证依赖的组件是容器中的组件
 * 4.@import
 *  给容器中自动创建出这两个类型的组件(调用无参构造器),默认组件的名字就是全类名
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)// 告诉springboot这是一个配置类=配置文件 beans.xml
//@ConditionalOnBean(name = "tom")//当容器中有tom组件时,下面这一堆才会生效
@ConditionalOnMissingBean(name = "tom")//当容器中没有tom组件时,下面这一堆才会生效
@ImportResource("classpath:beans.xml")//随便一个配置类中用此注解指定配置文件路径,可放入容器中
@EnableConfigurationProperties(Car.class)//1.开启谁的属性配置功能,2.把这个组件自动注册到容器中
public class MyConfig {


//    外部无论对配置类中的这个组件注册方法调用多少次,获取的都是之前注册容器中的单实例
//    @ConditionalOnBean(name = "tom")//当容器中有tom组件时,才注册这个组件
    @Bean//给容器中添加组件，方法名=组件id，返回类型=组件类型，返回值=组件在容器中的实例
    public User user01() {
        return new User("hh", 18);
    }

    @Bean("tom1")// 组件名默认是方法名，可自定义
    public Pet pet() {
        return new Pet("tomcat");
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        template.setConnectionFactory(factory);
//key序列化方式
        template.setKeySerializer(redisSerializer);
//value序列化
        template.setValueSerializer(redisSerializer);
//value hashmap序列化
        template.setHashValueSerializer(redisSerializer);
//key haspmap序列化
        template.setHashKeySerializer(redisSerializer);
//
        return template;
    }
}
