package com.javase.thread.advance;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlockingQueueClass {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		frame.action();
	}
}

class MyFrame extends JFrame {
	private static final long serialVersionUID = 1380085216941482146L;
	ImagesBuilder imagesBuilder;// 生产图片
	ImagesShower imagesShower;// 显示图片
	BlockingQueue<BufferedImage> queue;// 缓冲
	JPanel panel;// 显示面板
	JLabel label;// 显示图片的控件
	BufferedImage person;// 贴图素材

	public MyFrame() {
		try {
			person = ImageIO.read(new FileInputStream(
					"src/main/resources/image/back.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imagesBuilder = new ImagesBuilder();
		imagesShower = new ImagesShower();
		queue = new LinkedBlockingQueue<BufferedImage>(5);
		panel = new JPanel();
		label = new JLabel();
		// 初始化窗口布局
		this.add(panel);
		panel.add(label);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	/** 内部类共享数据queue方便 */
	class ImagesBuilder extends Thread {
		int i = 0;

		public void run() {
			while (true) {
				// 生产图片,创建图片对象
				BufferedImage img = new BufferedImage(300, 200,
						BufferedImage.TYPE_4BYTE_ABGR);
				// 将back贴到img上
				i++;// 每次都贴图位置向右移动一个像素
				int x = i % 300;// x = (0,299)
				Graphics g = img.getGraphics();
				g.drawImage(person, x, 0, null);
				// 插入到队列
				try {
					queue.put(img);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class ImagesShower extends Thread {
		public void run() {
			while (true) {
				try {
					// 从队列中取照片
					BufferedImage img = queue.take();
					// 送到label上显示照片
					label.setIcon(new ImageIcon(img));
					label.setText(queue.size() + "");
					// 休眠 1/24秒
					Thread.sleep(1000 / 24);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/** 启动软件, 启动线程 */
	public void action() {
		imagesBuilder.start();
		imagesShower.start();
	}
}
