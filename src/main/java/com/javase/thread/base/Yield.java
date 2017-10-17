package com.javase.thread.base;

/**
 * 线程的让出(yield)现象
 * 
 */
public class Yield {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(getName() + ":" + i);
					// 让出处理器, 返回到Runnable状态
					Thread.yield();
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(getName() + ":" + i);
					Thread.yield(); // 暂停当前正在执行的线程
				}
			}
		};
		t1.start();
		t2.start();
	}
}
