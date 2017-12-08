package com.itmei.offer;

/**
 * Created by qiaodan on 2017/12/8.
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名："+this.getName()+"年龄："+this.getAge();
    }
}
