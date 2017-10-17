package com.javase.gui.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class PaintFillColor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PaintFillColor() {
		setBounds(350, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.blue);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.drawRect(100, 300, 150, 100);
		g.drawRoundRect(300, 200, 200, 200, 200, 200);
		/*
		 * x - 要绘制矩形的 x 坐标。 y - 要绘制矩形的 y 坐标。 width - 要绘制矩形的宽度。 height -
		 * 要绘制矩形的高度。 arcWidth - 4 个角弧度的水平直径。 arcHeight - 4 个角弧度的垂直直径。
		 */
		g.setColor(Color.red);
		g.fillRect(100, 100, 100, 100);
		g.setColor(Color.green);
		g.fillOval(200, 100, 150, 150);
		// 填充夜色 圆形填充

		g.fill3DRect(150, 450, 50, 50, false);
		g.fillArc(200, 450, 50, 50, 50, 50);
		g.fillRect(250, 450, 50, 50);
		g.fillRoundRect(300, 450, 50, 50, 50, 50);
		g.drawString("如果", 400, 150);
	}

	public static void main(String[] args) {
		new PaintFillColor();
	}

}
