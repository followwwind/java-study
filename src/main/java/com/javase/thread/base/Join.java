package com.javase.thread.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 线程等待 1) 创建一个线程表 2) t1负责向线性表插入10个随机数据 3) t2线程启动以后等待t1的完成(t1.join()) t2
 * 线程执行了t1.join()方法以后t2立即 block 状态, 在t1结束以后t2才回到Runnable t2会继续执行, 将线性表中10个数据排序.
 * 4) 同时启动t1, t2
 */
public class Join {
	public static void main(String[] args) {
		final List<Integer> list = new ArrayList<>();
		// t1 负责生产10个整数
		final Thread t1 = new Thread() {
			public void run() {
				System.out.println("开始生产数据");
				Random r = new Random();
				Set<Integer> set = new HashSet<Integer>();
				for (; set.size() < 10;) {
					set.add(r.nextInt(100));
					System.out.println(set);
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
				}
				list.addAll(set);
				System.out.println("结束生产数据");
			}
		};
		// t2 等待t1结束以后对线性表排序
		final Thread t2 = new Thread() {
			public void run() {
				System.out.println("t2等待t1的完成");
				try {
					t1.join(); // 谁调用join谁阻塞
					System.out.println("t1结束了!");
					Collections.sort(list);
					System.out.println(list);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t1.start();
		t2.start();
	}
}
