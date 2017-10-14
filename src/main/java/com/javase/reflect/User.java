package com.javase.reflect;

public class User {

    private String name;
    public int age;

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

    public void printInfo(){
        System.out.println("name:" + name + ",age:" + age);
    }

    public static void printStatic(){
        System.out.println("this is a static method");
    }
}
