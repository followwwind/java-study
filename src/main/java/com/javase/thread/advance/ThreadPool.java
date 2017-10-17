package com.javase.thread.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池用于:
 * 1:控制线程数量
 * 2:重用线程
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"正在执行任务!");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("线程被中断了!");
					}
					System.out.println(t+"运行任务完毕!");
				}
			};
			threadPool.execute(runn);
		}
		System.out.println("所有任务均已指派完毕!");
		
		threadPool.shutdownNow();
		System.out.println("线程池已关闭!");
	}
}