package com.javase.gui.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintRectangle extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7101991204211258200L;

	PaintRectangle() {
		setBounds(350, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green);
		g.drawRect(10, 20, 300, 300);
	}

	public static void main(String[] args) {
		new PaintRectangle();
	}
}
