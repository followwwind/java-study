package com.javase.network.datagram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP服务端
 * 
 * @author Administrator
 * 
 */
public class Server {
	public static void main(String[] args) {
		try {
			/*
			 * 1:创建UDP的Socket 2:准备一个接收包 3:接收远端计算机发送过来的数据，并存入到接收包中
			 * 当接收完毕后，接收包会多了一些信息 主要为: 1:远端发送过来的数据 2:包也知道实际接收的字节量
			 * 3:也知道了数据从哪里来(远端地址信息) 4:从包中取出数据并还原内容。
			 */
			// 1
			/*
			 * TCP协议的端口与UDP协议的端口是 不冲突的。
			 */
			DatagramSocket socket = new DatagramSocket(8088);

			// 2
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);

			// 3
			socket.receive(packet);

			// 4// 包中的字节数组，就是data
			String message = new String(packet.getData(), 0,
					packet.getLength(), "UTF-8");
			System.out.println("客户端说:" + message);

			// 回复客户端
			// 2
			String str = "你好客户端!";
			data = str.getBytes("UTF-8");

			// 3 从客户端发送过来的包中得知客户端地址信息
			InetAddress address = packet.getAddress();
			int port = packet.getPort();

			packet = new DatagramPacket(data,// 要发送的数据所在的字节数组
					data.length,// 发送多少个字节
					address, // 远端地址
					port // 远端端口
			);

			// 4
			socket.send(packet);

			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}