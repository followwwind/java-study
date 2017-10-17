package com.javase.thread.base;

/**
 * 方法是可以被并发调用的
 */
public class InterCurrent {
	public static void main(String[] args) {
		final Koo k = new Koo();
		k.test();
		Thread t = new Thread() {
			public void run() {
				// 在匿名内部类中访问, 外部的局部变量
				// 这个变量必须是 final 的
				k.test();
			}
		};
		t.start();
	}
}

class Koo {
	public void test() {
		Thread t = Thread.currentThread();
		System.out.println("调用test()的线程:" + t.getId() + "," + t.getName());
	}
}
