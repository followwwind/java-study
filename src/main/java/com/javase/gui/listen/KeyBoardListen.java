package com.javase.gui.listen;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyBoardListen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s = null;
	private JLabel label;

	KeyBoardListen() {
		setLayout(new FlowLayout());
		label = new JLabel();
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				s = "按下的键是Type：" + e.getKeyChar();
				label.setText(s);
				System.out.println(s);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				s = "释放的键是：" + e.getKeyChar();
				label.setText(s);
				System.out.println(s);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				s = "按下的键是Press：" + e.getKeyChar();
				label.setText(s);
				System.out.println(s);
			}
		});
		add(label);
		setBounds(350, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new KeyBoardListen();
	}
}
