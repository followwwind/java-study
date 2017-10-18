package com.javase.network.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	private DatagramSocket datagramSocket;

	public UDPServer() {
		try {
			datagramSocket = new DatagramSocket(8088);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			byte[] data = new byte[100];
			DatagramPacket packet = new DatagramPacket(data, data.length);

			datagramSocket.receive(packet);

			// 4// 包中的字节数组，就是data
			String message = new String(packet.getData(), 0,
					packet.getLength(), "UTF-8");
			System.out.println("客户端说:" + message);

			// 回复客户端
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
			datagramSocket.send(packet);

			datagramSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UDPServer server = new UDPServer();
		server.start();

	}
}
