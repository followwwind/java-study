package com.javase.gui.layout;

import java.awt.FlowLayout;
import javax.swing.*;

public class SetFlowLayout {
	JFrame frame;
	JButton[] button;

	SetFlowLayout() {
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		button = new JButton[3];
		for (int i = 0; i < 3; i++) {
			button[i] = new JButton("" + i);
			frame.add(button[i]);
		}
		frame.setBounds(350, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SetFlowLayout();
	}
}
