package com.javase.gui.listen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MouseListen {
	JLabel label;
	JFrame frame;

	MouseListen() {
		frame = new JFrame("鼠标监听");
		// frame.setLayout(new FlowLayout());
		label = new JLabel("标签");
		frame.add(label);
		label.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("鼠标释放的坐标[" + arg0.getX() + "," + arg0.getY()
						+ "]");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("鼠标经过的坐标[" + arg0.getX() + "," + arg0.getY()
						+ "]");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("鼠标在窗口之外");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "鼠标进入窗口");
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				label.setText("鼠标点击的坐标[" + arg0.getX() + "," + arg0.getY()
						+ "]");
			}
		});
		frame.setBounds(350, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MouseListen();
	}
}