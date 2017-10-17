package com.javase.gui.layout;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SetCardLayout {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		CardLayout card = new CardLayout();
		f.setLayout(card);
		Container c = f.getContentPane();
		JButton[] b = new JButton[6];
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton("第" + (i + 1) + "页");
			c.add(b[i], "page" + (i + 1));
		}
		b[0].setBackground(Color.blue);
		b[1].setBackground(Color.yellow);
		b[2].setBackground(Color.red);
		b[3].setBackground(Color.green);
		b[4].setBackground(Color.orange);
		b[5].setBackground(Color.pink);
		f.setSize(300, 300);
		f.setVisible(true);
		card.show(c, "1");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			card.next(c);
		}
		/*
		 * for (int i = 0; i < 6; i++) { try { while (true) {
		 * Thread.sleep(1000); card.next(c); } } catch (InterruptedException e)
		 * { e.printStackTrace(); } }
		 */
	}
}
