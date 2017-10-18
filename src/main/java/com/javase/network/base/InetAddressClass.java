package com.javase.network.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wind
 */
public class InetAddressClass {
	public static void main(String[] args) {
		try {
			// 给出主机名,查找相应的地址,返回主机名/IP地址
			InetAddress inetAddress = InetAddress.getByName("mail.jlu.edu.cn");
			System.out.println("输入主机的名称mail.jlu.edu.cn");
			System.out.println("主机mail.jlu.edu.cn为" + inetAddress);
			// 返回主机名
			String strName = inetAddress.getHostName();
			System.out.println("程序获取的主机名称" + strName);
			// 返回IP地址字符串
			System.out.println("程序获取的IP地址为" + inetAddress.getHostAddress());
			// 返回本地主机名/IP地址
			System.out.println("主机为:" + InetAddress.getLocalHost());
			// 返回本地主机名
			System.out.println("本机的主机名称为"
					+ InetAddress.getLocalHost().getHostName());
			// 返回本地IP地址字符串
			System.out.println("本机的IP地址为"
					+ InetAddress.getLocalHost().getHostAddress());
			// 获取主机名/回送地址
			/*
			 * InetAddress loopbackAddress=InetAddress.getLoopbackAddress();
			 * System.out.println("回送地址的主机为"+loopbackAddress);
			 * System.out.println("回送地址的主机名为"+loopbackAddress.getHostName());
			 * System
			 * .out.println("回送地址的IP字符串为"+loopbackAddress.getHostAddress());
			 */
			byte[] bytes = new byte[] { 127, 0, 0, 1 };
			// 获取网络地址
			InetAddress address = InetAddress.getByAddress(bytes);
			System.out.println("回送地址的主机为" + address.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
