package com.gg.controller;

import java.lang.reflect.Field;

public class bbb {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        获取对象的反射
//        Class<aaa> aaaClass = aaa.class;
//        getD... 可获取所有字段，获取私有字段a
//        Field a = aaaClass.getDeclaredField("a");
//        设置访问私有属性权限（什么都可以访问）
//        a.setAccessible(true);
//        指定获取字段的对象实例
//        Object o = a.get(new aaa());
//        System.out.println(o);

        Class<bbb> bbbClass = bbb.class;
        bbb bbb = new bbb();
        System.out.println(bbb.getClass());
        System.out.println(bbbClass.getClassLoader());
    }
}
