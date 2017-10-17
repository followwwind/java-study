package com.javase.thread.base;

/**
 * 守护线程，又称为后台线程 使用上与前台线程无异。只是结束时机上，守护线程有 一个强制措施: 当一个进程中的所有前台线程都结束时，进程就要结束，
 * 无论该进程中的守护线程是否还在运行都要被强制中断。
 * 
 * @author Administrator
 * 
 */
public class SetDaemon {
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("t1:" + i);
				}
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (;;) {
					System.out.println("t2:0");
				}
				/*
				 * while(true){
				 * 
				 * }
				 */
			}
		};
		// t1 默认是前台线程
		// t2 被设置为后台线程
		// 先设置,再启动
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}
