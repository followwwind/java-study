package com.javase.thread.middle;

/**
 * 线程的并发安全性问题 同步锁 互斥锁
 */
public class Synchronized {
	public static void main(String[] args) {
		// methdodOne();
		// methodTwo();
	}

	// 同步锁
	public static void methdodOne() {
		final Shop s1 = new Shop();
		final Shop s2 = new Shop();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				s1.methodA();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				s2.methodB();
			}
		});
		t1.start();
		t2.start();
	}

	// 互斥锁
	public static void methodTwo() {
		final Shop s = new Shop();
		Thread t1 = new Thread() {
			public void run() {
				s.methodA();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				s.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop {
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		for (int i = 0; i < 3; i++) {
			System.out.println(t + ":方法A-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public synchronized void methodB() {
		Thread t = Thread.currentThread();
		for (int i = 0; i < 3; i++) {
			System.out.println(t + ":方法B-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
