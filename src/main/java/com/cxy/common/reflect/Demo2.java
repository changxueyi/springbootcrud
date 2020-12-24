package com.cxy.common.reflect;

import java.lang.reflect.Constructor;

/**
 * @ClassName Demo2
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/12/8 10:38
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //1. 获取Person 的class 对象
        Class personClass = Person.class;
        Constructor constructor1 = personClass.getConstructor(int.class,int.class);
        System.out.println(constructor1);

        //有了构造函数对象，就可以直接创建对象了
        System.out.println("************************");
        Object person = constructor1.newInstance(11,23);
        System.out.println(person);
        System.out.println("****************");
        Constructor constructor2 = personClass.getConstructor();
        System.out.println(constructor2);
        //创建对象
        Object person1 = constructor2.newInstance();
        System.out.println(person1);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
        Object o = personClass.newInstance();
        System.out.println(o);
    }
}