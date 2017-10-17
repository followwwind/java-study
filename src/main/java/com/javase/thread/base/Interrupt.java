package com.javase.thread.base;

public class Interrupt {
	public static void main(String[] args) {
		// t2打断t1的休眠, t2休眠2秒, t1休眠5秒;
		final Thread t1 = new Thread() {
			public void run() {
				System.out.println("t1启动");
				try {
					Thread.sleep(5000);
					// 自然醒
					System.out.println("t1醒来!");
				} catch (InterruptedException e) {
					// t1被打断, 提前结束sleep醒来
					e.printStackTrace();
					System.out.println("谁吵醒我了!");
				}
			}
		};
		final Thread t2 = new Thread() {
			public void run() {
				System.out.println("t2开始");
				try {
					Thread.sleep(2000);
					System.out.println("上课!");
					// 在t2线程中调用t1线程的打断方法
					// 打断t1线程的休眠方法
					t1.interrupt();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
