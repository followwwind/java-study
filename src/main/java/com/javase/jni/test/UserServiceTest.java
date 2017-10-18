package com.javase.jni.test;


import com.javase.jni.service.UserService;

public class UserServiceTest {
	static{
		System.loadLibrary("src/main/java/com/javase/jni/dll/JavaJNI");
	}
	public static void main(String[] args) {
		UserService userService = new UserService();
		long s = System.currentTimeMillis();
		userService.getUserInfo();
		long e = System.currentTimeMillis();
		System.out.println((e - s)+"ms");
		long start = System.currentTimeMillis();
		System.out.println("Hello JavaJNI");
		for(int i=0;i<100;i++){
			System.out.print(i+"\t");
		}
		System.out.println();
		long end = System.currentTimeMillis();
		System.out.println((end - start)+"ms");
		
	}
}
