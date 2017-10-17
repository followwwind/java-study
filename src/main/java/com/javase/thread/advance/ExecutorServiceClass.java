package com.javase.thread.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceClass {
	public static void main(String[] args) {
		//创建了10个任务
		Task t1 = new Task();
		Task t2 = new Task();
		Task t3 = new Task();
		Task t4 = new Task();
		Task t5 = new Task();
		/*Task t6 = new Task();
		Task t7 = new Task();
		Task t8 = new Task();
		Task t9 = new Task();
		Task t10 = new Task();*/
		//创建一个固定数量的线程, 线程数量4
		//将10个任务提交给线程池去执行.
		//线程池执行时候, 观察:
		// 1) 是否是最多有4个并发执行的线程
		// 2) 线程是否在执行任务时候被重复使用了
		ExecutorService pool = 
			Executors.newFixedThreadPool(4);
		//将任务t1~t10交给线程池去执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		/*pool.execute(t6);
		pool.execute(t7);
		pool.execute(t8);
		pool.execute(t9);
		pool.execute(t10);*/
	}
}
class Task implements Runnable{
	public void run(){
		Thread t = Thread.currentThread();
		for(int i=0; i<5; i++){
			System.out.println(t.getId()+":"+
					t.getName()+":"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}