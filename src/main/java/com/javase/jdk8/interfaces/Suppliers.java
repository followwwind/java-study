package com.javase.jdk8.interfaces;

import java.util.function.Supplier;
/**
 *  Suppliers接口产生一个给定类型的结果，需要类有无参构造函数
 * @author 
 *
 */
class ASup{
	private String name;  
    private int age;  
    public ASup() {
		
	}
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
    
}

public class Suppliers {
	public static void main(String[] args) {
		Supplier<ASup> supplier = ASup :: new; //必须有无参构造函数
		ASup a = supplier.get();
		System.out.println(a.getName());
	}
}
