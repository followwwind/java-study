package com.javase.gui.graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.math.BigDecimal;
import static java.lang.Math.*;

public class HeartCurve {
	long start = System.currentTimeMillis();
	private Frame f = new Frame("curve");
	private final int SIZE = 600;
	private MyCanvas area = new MyCanvas();
	private BufferedImage image = new BufferedImage(SIZE, SIZE,
			BufferedImage.TYPE_INT_RGB);
	private Graphics g = image.getGraphics();
	private final double STEP = 0.00001;

	private void init() {
		area.setPreferredSize(new Dimension(SIZE, SIZE));
		g.setColor(Color.white);
		g.fillRect(0, 0, SIZE, SIZE);
		g.setColor(Color.black);
		g.drawLine(0, SIZE / 2, SIZE, SIZE / 2);
		g.drawLine(SIZE / 2, 0, SIZE / 2, SIZE);
		int x1, y1, x2, y2;
		for (double t = -Math.PI; t < Math.PI; t = t + STEP) {
			g.setColor(Color.black);
			x1 = axisSystem(axisX(t));
			y1 = axisSystem(axisY(t));
			x2 = axisSystem(axisX(t + STEP));
			y2 = axisSystem(axisY(t + STEP));
			// g.drawLine(x1, y1, x2, y2);
			g.drawLine(y1, SIZE - x1, y2, SIZE - x2);
		}
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		long end = System.currentTimeMillis();
		g.setColor(Color.red);
		g.setFont(new Font("Times", Font.BOLD, 15));
		g.drawString("步长值：" + BigDecimal.valueOf(STEP), 20, 30);
		g.drawString("画图所用时间：" + (end - start) + "毫秒", 20, 50);
		area.repaint();
		f.add(area);
		f.pack();
		f.setVisible(true);
	}

	private double axisX(double t) {
		return 2 * cos(t) - cos(2 * t);
	}

	private double axisY(double t) {
		return 2 * sin(t) - sin(2 * t);
	}

	private int axisSystem(double d) {
		return (int) ((0.5 + d / 8) * SIZE);
	}

	private class MyCanvas extends Canvas {
		private static final long serialVersionUID = 6501274767759295310L;

		public void paint(Graphics g) {
			g.drawImage(image, 0, 0, null);
		}
	}

	public static void main(String[] args) {
		new HeartCurve().init();
	}
}