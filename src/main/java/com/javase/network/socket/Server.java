package com.javase.network.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 * 
 * @author Administrator
 * 
 */
public class Server {
	/*
	 * 运行在服务端的Socket 该类的作用是: 1:申请服务端口,客户端就是通过它申请的服务端口 连接上服务端应用程序的
	 * 2:监听申请的服务端口从而感知到客户端的连接，并 创建一个Socket与该客户端通信.
	 */
	private ServerSocket server;
	/*
	 * 存放所有客户端输出流的集合，用于广播消息
	 */
	private List<PrintWriter> allOut;

	/**
	 * 构造方法，用来初始化服务端
	 * 
	 * @throws Exception
	 */
	public Server() throws Exception {
		try {
			/*
			 * 实例化ServerSocket的同时，指定服务端口 客户端就是通过该端口连接上服务端的
			 */
			server = new ServerSocket(8088);

			allOut = new ArrayList<PrintWriter>();
		} catch (Exception e) {
			System.out.println("服务端初始化失败!");
			throw e;
		}
	}

	/**
	 * 将给定的输出流存入共享集合中
	 * 
	 * @param out
	 */
	private synchronized void addOut(PrintWriter out) {
		allOut.add(out);
	}

	/**
	 * 将给定的输出流从共享集合中删除
	 * 
	 * @param out
	 */
	private synchronized void removeOut(PrintWriter out) {
		allOut.remove(out);
	}

	/**
	 * 将给定的消息发送给多有客户端
	 * 
	 * @param message
	 */
	private synchronized void sendMessage(String message) {
		for (PrintWriter out : allOut) {
			out.println(message);
		}
	}

	/**
	 * 服务端开始工作的方法
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		try {
			/*
			 * ServerSocket提供了一个方法: Socket accept() 该方法是一个阻塞方法，用于监听其打开的
			 * 8088端口，当一个客户端通过该端口与 服务端连接时，accept方法就会解除阻塞 然后创建一个Socket实例并返回。这个
			 * Socket的作用就是与刚刚连上的客户端进行 通讯。
			 */
			while (true) {
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				// 启动一个线程来处理该客户端的交互工作
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}

		} catch (Exception e) {
			System.out.println("服务端运行失败!");
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			Server server = new Server();
			server.start();
		} catch (Exception e) {
			System.out.println("服务端启动失败!");
			e.printStackTrace();
		}
	}

	/**
	 * 该线程的作用是与指定的客户端进行交互工作。
	 * 
	 * @author Administrator
	 * 
	 */
	class ClientHandler implements Runnable {
		// 当前线程交互的客户端的Socket
		private Socket socket;
		// 该客户端地址信息
		private String host;

		public ClientHandler(Socket socket) {
			this.socket = socket;
			/*
			 * 通过Socket获取远程计算机地址信息 对于服务端而言，远程计算机就是客户端了
			 */
			InetAddress address = socket.getInetAddress();
			// 获取IP地址
			host = address.getHostAddress();
		}

		public void run() {
			PrintWriter pw = null;
			try {
				// 广播给所有客户端当前用户上线了
				sendMessage("[" + host + "]上线了!");

				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
				pw = new PrintWriter(osw, true);

				/*
				 * 将该客户端的输出流存入共享集合，以便消息 可以广播给该客户端
				 */
				addOut(pw);

				/*
				 * 广播给所有客户端，当前在线人数
				 */
				sendMessage("当前在线[" + allOut.size() + "]人");

				/*
				 * Socket提供了一个方法: InputStream getInputStream() 用于获取远端计算机发送过来的数据
				 */
				InputStream in = socket.getInputStream();

				InputStreamReader isr = new InputStreamReader(in, "UTF-8");

				BufferedReader br = new BufferedReader(isr);
				/*
				 * 服务端读取客户端发送过来的每一句字符串时 由于客户端所在操作系统不同，这里当客户端 断开时的结果也不同。
				 * 当windows的客户端断开连接时，br.readLine 方法会抛出异常
				 * 
				 * 当linux的客户端断开连接时，br.readLine 方法会返回null
				 */
				String message = null;
				while ((message = br.readLine()) != null) {
					// System.out.println(host+"说:"+message);
					// pw.println(host+"说:"+message);
					// 广播给所有客户端
					sendMessage(host + "说:" + message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 客户端断开连接了

				// 将该客户端的输出流从共享集合中删除
				removeOut(pw);

				// 广播给所有客户端当前用户下线了
				sendMessage("[" + host + "]下线了!");
				/*
				 * 广播给所有客户端，当前在线人数
				 */
				sendMessage("当前在线[" + allOut.size() + "]人");
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
