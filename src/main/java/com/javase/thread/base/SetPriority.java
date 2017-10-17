package com.javase.thread.base;

/**
 * 线程的优先级别 1 ~ 10 级别 默认级别: 5
 */
public class SetPriority {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.setPriority(Thread.NORM_PRIORITY);// 5
		t2.setPriority(Thread.MIN_PRIORITY);// 1
		t3.setPriority(Thread.MAX_PRIORITY);// 10
		t1.start();// 启动t1的run()
		t2.start();// 启动t2的run()
		t3.start();// 启动t3的run()
	}
}

class MyThread extends Thread {
	public void run() {
		// 在软件运行期间, 被那几个线程对象调用?
		Thread t = Thread.currentThread();
		// t 是谁? 调用当前方法的线程, 分别是
		// t1 t2 t3
		for (int i = 0; i < 100; i++) {
			System.out.println(i + "," + t.getId() + "," + t.getName());
		}
		System.out.println(t.getName() + "Over!");
	}
}
