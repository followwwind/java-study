package com.javase.thread.advance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列测试
 */
public class LBQClass {
	public static void main(String[] args) {
		final BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);
		queue.add("Tom");
		queue.add("Jerry");
		queue.add("Nemo");
		queue.add("Andy");
		queue.add("John");
		System.out.println(queue);

		Thread t1 = new Thread() {
			public void run() {
				try {
					System.out.println("开始插入数据");
					// queue.put("Robin");
					boolean success = queue.offer("Robin", 5, TimeUnit.SECONDS);
					System.out.println("结束插入数据" + success);
					System.out.println(queue);
				} catch (InterruptedException e) {
					// 在阻塞期间, 被其他线程调用了
					// 当前线程的中断方法, 会引起这个异常
					e.printStackTrace();
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				try {
					System.out.println("启动,等2秒");
					Thread.sleep(2000);
					String s = queue.take();
					System.out.println("取出" + s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
