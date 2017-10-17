package com.javase.thread.middle;

/**
 * 静态方法被synchronized修饰后，锁对象为当前类的
 * 类对象(Class的实例)
 * 
 * java中有一个特殊的类叫做:Class
 * 这个类的每一个实例用于描述一个类的信息。
 * 当我们使用到某个类时，JVM首先会加载该类的class文件
 * 然后将该类的描述用一个Class的实例保存，所以对于java
 * 中的任何一个类而言，在JVM中都有一个且只有一个Class的
 * 实例来描述。
 * 由于每个类都只有一个Class的实例描述，所以，静态方法
 * 对该对象加锁，那么多个线程看到的都一定是这个对象，所以
 * 静态方法被synchronized修饰后一定具有同步效果。
 * 
 * 反射
 * 
 * @author Administrator
 *
 */

class TicketB implements Runnable {
	private static int num = 100;
	// Object obj = new Object();
	boolean flag = true;

	public void run() {
		// System.out.println("this:"+this.getClass());

		if (flag)
			while (true) {
				synchronized (TicketB.class)// (this.getClass())
				{
					if (num > 0) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
						}
						System.out.println(Thread.currentThread().getName()
								+ ".....obj...." + num--);
					}
				}
			}
		else
			while (true) {
				// this.show();
				show();
			}
	}

	public static synchronized void show() {
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			System.out.println(Thread.currentThread().getName()
					+ ".....function...." + num--);
		}
	}
}

class StaticSynFunctionLock {
	public static void main(String[] args) {
		TicketB t = new TicketB();

		// Class clazz = t.getClass();
		//
		// Class clazz = Ticket.class;
		// System.out.println("t:"+t.getClass());

		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);

		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		t.flag = false;
		t2.start();
	}
}
