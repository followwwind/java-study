package com.javase.network.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP客户端
 * 
 * @author Administrator
 * 
 */
public class Client {
	public static void main(String[] args) {
		try {
			/*
			 * 1:创建UDP的Socket 2:准备要发送的数据 3:打包 1:存入数据 2:填写地址信息 4:发送
			 * 以后每次发送数据循环2,3,4即可
			 */
			// 1
			DatagramSocket socket = new DatagramSocket();

			// 2
			String str = "你好服务端!";
			byte[] data = str.getBytes("UTF-8");

			// 3
			InetAddress address = InetAddress.getByName("localhost");
			int port = 8088;

			DatagramPacket packet = new DatagramPacket(data,// 要发送的数据所在的字节数组
					data.length,// 发送多少个字节
					address, // 远端地址
					port // 远端端口
			);

			// 4
			socket.send(packet);

			// 接收服务端发送回来的信息
			// 2
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);

			// 3
			socket.receive(packet);

			// 4
			String message = new String(packet.getData(),// 包中的字节数组，就是data
					0, packet.getLength(), "UTF-8");
			System.out.println("服务端说:" + message);

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
