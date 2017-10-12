package com.javase.jdk8.interfaces;

/**
 * jdk8函数式接口，SAM类型的接口（Single Abstract Method）
 * 定义了这种类型的接口，使得以其为参数的方法，可以在调用时，使用一个lambda表达式作为参数
 * 从SAM原则上讲，这个接口中，只能有一个函数需要被实现，但是也可以有如下例外:
 * 	1. 默认方法与静态方法并不影响函数式接口的契约，可以任意使用，即函数式接口中可以有静态方法，
 * 	一个或者多个静态方法不会影响SAM接口成为函数式接口，并且静态方法可以提供方法实现可以由 default 修饰的默认方法方法，
 * 	这个关键字是Java8中新增的，为的目的就是使得某一些接口，原则上只有一个方法被实现，但是由于历史原因，
 * 	不得不加入一些方法来兼容整个JDK中的API，所以就需要使用default关键字来定义这样的方法
 *  2. 可以有 Object 中覆盖的方法，也就是 equals，toString，hashcode等方法。
 * @author wind、
 *
 */


@FunctionalInterface
interface AInterface{
    String getName(String name);
}

public class FunInterface {

	public static void testFun(AInterface a){
		System.out.println(a.getName("AAA"));
	}
	
	public static void main(String[] args) {
		//新方法
		AInterface a = (name) -> "hello " + name;
		System.out.println("a" + a.getName("world"));

		//老方法
		AInterface b = new AInterface() {
			@Override
			public String getName(String name) {
				return "hello " + name;
			}
		};
		System.out.println("b" + b.getName("world"));

		testFun(val -> "hello=" + val);
	}
	
}
