package com.javase.gui.component.advance;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class JScrollBarDemo extends JFrame {
	/**
	 * 
	 */
	private JScrollBar bar;
	private static final long serialVersionUID = 1L;

	JScrollBarDemo() {
		bar = new JScrollBar();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		bar.add(p1);
		bar.add(p2);
		add(bar);
		setBounds(500, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JScrollBarDemo();
	}
}
