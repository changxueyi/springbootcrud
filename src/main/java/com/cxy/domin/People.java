package com.cxy.domin;

/**
 * @ClassName People
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/28 17:41
 */
public class People {
    private Integer id;
    private String age;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}