package com.cxy.common.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Field;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/12/8 10:24
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //1. 获取Person 的class 对象
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field field:fields){
            System.out.println(field);
            //什么也不输出，因为getFields 只会获取所有的public 修饰的成员变量
        }

        System.out.println("*****************************");
        Field a = personClass.getField("a");
        //获取到成员变量，一个是设置值，一个是获取值
        Person p = new Person();
        Object o = a.get(p);
        System.out.println(o);
        a.set(p,"张三");
        System.out.println(p);

        // 不考虑修饰符
        Field[] result = personClass.getDeclaredFields();
        for (Field result1 : result){
            System.out.println(result1);
        }
    }
}