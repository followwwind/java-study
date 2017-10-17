package com.javase.gui.listen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionListen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;

	MouseMotionListen() {
		// setLayout(new FlowLayout()); //无法布局,在鼠标监听时
		label = new JLabel("标签");
		add(label);
		label.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("鼠标经过的坐标[" + arg0.getX() + "," + arg0.getY()
						+ "]");
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("鼠标拖拽的坐标[" + arg0.getX() + "," + arg0.getY()
						+ "]");
			}
		});
		setBounds(350, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MouseMotionListen();
	}
}
