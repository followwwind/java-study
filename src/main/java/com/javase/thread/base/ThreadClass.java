package com.javase.thread.base;

class Runnables implements Runnable {
	Thread thread = Thread.currentThread();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(thread.getName() + ":" + i);
		}
	}

}
/**
 * 第一种创建线程的方式存在两个不足:
 * 1:由于java是单继承的，所以在一个项目中，我们常常
 *   会让一个类去指定扩展一个父类，但若这个类还需要
 *   实现线程的功能，就会导致产生继承冲突。
 * 2:由于当前类重写了run方法并指定了当前线程要执行的
 *   任务，这就导致了线程与线程要执行的任务有一个强
 *   耦合关系。不利于线程的重用。  
 * @author Administrator
 *
 */
class Threads extends Thread {
	Thread thread = Thread.currentThread();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(thread.getName() + ":" + i);
		}
	}
}

/**
 * 线程类Thread跟接口Runnable
 * 
 * @author wind
 * 
 */
public class ThreadClass {
	public static void main(String[] args) {
		Runnables runnables = new Runnables();
		Threads threads = new Threads();
		/*
		 * 线程的start方法的作用是启动线程 该方法会很快的执行完毕，作用是将当前线程 注册到线程调度中，使该线程具有并发运行的 能力。
		 * 当该线程获取CPU时间片段后，它的run方法会 自动被调用。
		 */
		threads.start();
		runnables.run();
		System.out.println("main方法结束");
		/*
		 * Thread thread=new Thread(runnables); thread.start();
		 */
		// thread();
	}

	public static void thread() {
		//使用匿名内部类的形式创建线程
		Thread thread = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.print(i + " ");
				}
			}
		});
		thread.start();
	}
}
