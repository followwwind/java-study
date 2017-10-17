package com.javase.gui.layout;

import java.awt.GridLayout;

import javax.swing.*;

public class SetGridLayout {
	JFrame frame;
	JButton[] button;

	public SetGridLayout() {
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		frame.setLayout(new GridLayout(3, 4, 1, 1));
		/*
		 * GridLayout( ); 第一个、二哥参数表示网格分成的行、列， 第三个、四个参数表示网格之间的横纵间距
		 */
		button = new JButton[12];
		for (int i = 0; i < 12; i++) {
			button[i] = new JButton("" + i); // " "+1将数字转换成字符串“1”
			frame.add(button[i]);
		}
		frame.setBounds(350, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SetGridLayout();
	}
}
