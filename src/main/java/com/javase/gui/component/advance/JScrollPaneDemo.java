package com.javase.gui.component.advance;

import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.*;

public class JScrollPaneDemo {
	public static void main(String[] args) {
		JFrame f = new JFrame("表格效果");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(10, 5));
		JTextField[] cells = new JTextField[50];
		for (int i = 0; i < 50; i++) {
			cells[i] = new JTextField(String.valueOf(i), 5);
			p.add(cells[i]);
		}
		ScrollPane sp = new ScrollPane();// 滚动面板
		sp.add(p);
		f.add(sp, "Center");
		f.setSize(270, 200);
		f.setLocation(450, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
