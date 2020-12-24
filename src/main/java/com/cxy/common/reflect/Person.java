package com.cxy.common.reflect;

/**
 * @ClassName Person
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/12/8 10:24
 */
public class Person {
    private int age;
    private int name;

    public String a;

    public Person(int age, int name) {
        this.age = age;
        this.name = name;
    }

    public Person() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name=" + name +
                ", a='" + a + '\'' +
                '}';
    }
}