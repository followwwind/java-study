package com.javase.jdk8.interfaces;

import java.util.function.Supplier;
/**
 *  Suppliers接口产生一个给定类型的结果，需要类有无参构造函数
 * @author 
 *
 */

public class Suppliers {
	public static void main(String[] args) {
		Supplier<Person> supplier = Person :: new; //必须有无参构造函数
		Person a = supplier.get();
		System.out.println(a.getName());
	}
}
