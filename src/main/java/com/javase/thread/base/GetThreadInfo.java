package com.javase.thread.base;

/**
 * 找到调用主方法的线程
 */
public class GetThreadInfo {
	public static void main(String[] args) {
		// 获取调用当前方法的线程
		// 当前方法是主方法, 主线程调用主方法,
		// 这里获取的线程就是主线程
		Thread t = Thread.currentThread();
		// 线程有唯一的ID, 和名称
		// 获取id
		long id = t.getId();
		System.out.println("id:" + id);

		// 获取线程名字
		String name = t.getName();
		System.out.println("name:" + name);

		// 获取优先级
		int priority = t.getPriority();
		System.out.println("优先级:" + priority);

		// 是否活着
		boolean isAlive = t.isAlive();
		System.out.println("isAlive:" + isAlive);

		// 是否为守护线程
		boolean isDaemon = t.isDaemon();
		System.out.println("isDaemon:" + isDaemon);

		// 是否被中断
		boolean isInterrupted = t.isInterrupted();
		System.out.println("isInterrupted:" + isInterrupted);
		// main方法被主线程调用
	}
}
