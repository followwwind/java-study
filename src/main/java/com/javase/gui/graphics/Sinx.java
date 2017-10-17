package com.javase.gui.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;

public class Sinx extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6108008582331539776L;
	private static final double WIDTH = Toolkit.getDefaultToolkit()
			.getScreenSize().getWidth();
	private static final double HEIGHT = Toolkit.getDefaultToolkit()
			.getScreenSize().getHeight();
	private static final int INCREMENT = 20;

	public static void main(String[] args) {
		new Sinx();
	}

	public Sinx() {
		this.setTitle("画图像sinx/x");
		this.setLocation(50, 50);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLUE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	@Override  
    public void paint(Graphics g) {  
        super.paint(g);  
        Graphics2D g2d = (Graphics2D) g;  
        Color source = g2d.getColor();  
          
        g2d.setColor(Color.WHITE);  
        g2d.drawString("sinx/x 的图像", 50, 50);  
          
  
        // 画 X 轴  
        g2d.drawLine(INCREMENT, (int)HEIGHT/2, (int)WIDTH-INCREMENT, (int)HEIGHT/2);  
        g2d.drawLine((int)WIDTH-2*INCREMENT, (int)HEIGHT/2-5, (int)WIDTH-10, (int)HEIGHT/2);
        g2d.drawLine((int)WIDTH-2*INCREMENT, (int)HEIGHT/2+5, (int)WIDTH-10, (int)HEIGHT/2);
          
  
        // 画 Y 轴  
        g2d.drawLine((int)WIDTH/2, 40, (int)WIDTH/2, (int)HEIGHT-50);  
        g2d.drawLine((int)WIDTH/2, 40, (int)WIDTH/2-10, 50);  
        g2d.drawLine((int)WIDTH/2, 40, (int)WIDTH/2+10, 50);  
          
        // 将当前画笔移动到中心  
        g2d.translate((int) WIDTH / 2, (int) HEIGHT / 2);  
  
        // 利用GeneralPath类来画曲线  
        GeneralPath gp = new GeneralPath();  
  
        // 将GeneralPath的实例gp的画笔移动到当前画面的中心，但是这个点是相对于g2d画笔的中心的  
        gp.moveTo(0, 0);  
  
        // 画sin(x)/x 的图像  
//      drawSinxDX(gp, g2d);  
  
        // sin(x)的图像  
        drawSinx(gp, g2d);  
     // cos(x)的图像  
      // drawCosx(gp, g2d);  
  
        // tan(x)的图像  
//      drawTanx(gp, g2d);  
        g2d.setColor(source);  
    }	@SuppressWarnings("unused")
	private void drawTanx(GeneralPath gp, Graphics2D g2d) {
		for (double i = 0.000001; i <= 8 * Math.PI; i += 0.0001 * Math.PI) {
			gp.lineTo(20 * i, 100 * -Math.tan(i));
		}
		g2d.draw(gp);

		// 将当前画笔以原点为中心，旋转180度，画奇函数（关于原点对称）
		g2d.rotate(Math.PI);
		g2d.draw(gp);
	}

	@SuppressWarnings("unused")
	private void drawCosx(GeneralPath gp, Graphics2D g2d) {
		for (double i = 0.000001; i <= 8 * Math.PI; i += 0.0001 * Math.PI) {
			gp.lineTo(20 * i, 100 * -Math.cos(i));
		}
		g2d.draw(gp);

		// 将当前画笔以Y中为对称轴，画偶函数(关于Y轴对称)
		g2d.scale(-1, 1);
		g2d.draw(gp);
	}

	private void drawSinx(GeneralPath gp, Graphics2D g2d) {
		for (double i = 0.000001; i <= 8 * Math.PI; i += 0.0001 * Math.PI) {
			gp.lineTo(20 * i, 100 * -Math.sin(i));
		}
		g2d.draw(gp);
		g2d.rotate(Math.PI);
		g2d.draw(gp);
	}

	@SuppressWarnings("unused")
	private void drawSinxDX(GeneralPath gp, Graphics2D g) {
		for (double i = 0.000001; i <= 8 * Math.PI; i += 0.0001 * Math.PI) {
			gp.lineTo(20 * i, 100 * -Math.sin(i) / i);
		}
		g.draw(gp);
		g.scale(-1, 1);
		g.draw(gp);
	}
}
