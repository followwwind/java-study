package com.javase.thread.middle;

/*
 等待/唤醒机制。 

 涉及的方法：

 1，wait(): 让线程处于冻结状态，被wait的线程会被存储到线程池中。
 2，notify():唤醒线程池中一个线程(任意).
 3，notifyAll():唤醒线程池中的所有线程。

 这些方法都必须定义在同步中。
 因为这些方法是用于操作线程状态的方法。
 必须要明确到底操作的是哪个锁上的线程。


 为什么操作线程的方法wait notify notifyAll定义在了Object类中？ 

 因为这些方法是监视器的方法。监视器其实就是锁。
 锁可以是任意的对象，任意的对象调用的方式一定定义在Object类中。

 */
public class WaitNotify {
	public static boolean isFinish = false;
	public static Object obj=new Object();
	public static void main(String[] args) {
		final Thread t1 = new Thread() {
			public void run() {
				System.out.println("开始下载图片");
				for (int i = 0; i < 11; i++) {
					System.out.println("下载进度为:" + i * 10 + "%");
					try {
						Thread.sleep(1000 / 20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				isFinish = true;
				System.out.println("图片下载完成");
				System.out.println("线程等待完毕,开始唤醒");
				synchronized(obj){
					obj.notify();
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("开始显示图片");
				synchronized (obj) {
					try {
						obj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (isFinish) {
					System.out.println("显示图片");
				} else {
					System.out.println("下载失败");
				}

			}
		};
		t1.start();
		t2.start();
	}
}
