package com.javase.gui.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SetBorderLayout {
	JFrame frame;
	JButton[] button;

	public SetBorderLayout() {
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		frame.setTitle("BorderLayout");
		frame.setLayout(new BorderLayout());
		button = new JButton[5]; // 先分配数组空间范围
		button[0] = new JButton("北");
		frame.add(button[0], BorderLayout.NORTH);
		button[1] = new JButton("南");
		frame.add(button[1], BorderLayout.SOUTH);
		button[2] = new JButton("东");
		frame.add(button[2], BorderLayout.EAST);
		button[3] = new JButton("西");
		frame.add(button[3], BorderLayout.WEST);
		button[4] = new JButton("中");
		frame.add(button[4], BorderLayout.CENTER);
		frame.setBounds(350, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SetBorderLayout();
	}
}
