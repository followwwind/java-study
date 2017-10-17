package com.javase.gui.layout;

import java.awt.Button;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class SetBoxLayout extends JFrame {
	private static final long serialVersionUID = 1L;

	public SetBoxLayout() {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
		getContentPane().setBackground(Color.green);
		add(new Button("123"));
		add(new Button("123"));
		add(new Button("123"));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 700, 400);
	}

	public static void main(String[] args) {
		new SetBoxLayout();
	}
}
