package com.javase.network.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
	private DatagramSocket datagramSocket;

	public UDPClient() {
		try {
			datagramSocket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		try {
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
			datagramSocket.send(packet);

			// 接收服务端发送回来的信息
			// 2
			data = new byte[100];
			packet = new DatagramPacket(data, data.length);

			// 3
			datagramSocket.receive(packet);

			// 4
			String message = new String(packet.getData(),// 包中的字节数组，就是data
					0, packet.getLength(), "UTF-8");
			System.out.println("服务端说:" + message);

			datagramSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UDPClient client = new UDPClient();
		client.start();
	}
}
