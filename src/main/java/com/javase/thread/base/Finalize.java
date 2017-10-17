package com.javase.thread.base;

public class Finalize {
	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("unused")
		Wolf wolf = new Wolf();
		wolf = null;
		System.gc();// 尽快进行垃圾回收
		Thread.sleep(1000);
	}
}

class Wolf {
	// finalize 方法在垃圾回收线程回收对象时候
	// 被垃圾回收线程调用. 是对象的临终遗言
	public void finalize() throws Throwable {
		super.finalize();
		Thread t = Thread.currentThread();
		System.out.println("GC:" + t.getId() + "," + t.getName() + ","
				+ t.isDaemon());
		System.out.println("我还会回来的!");
	}
}
