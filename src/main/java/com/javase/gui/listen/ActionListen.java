package com.javase.gui.listen;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton buttonOne = new JButton("按钮");
	JButton buttonTwo = new JButton("melody");
	JButton buttonThree = new JButton("soft");

	ActionListen() {
		setLayout(new FlowLayout());
		add(buttonOne);
		add(buttonTwo);
		add(buttonThree);
		buttonOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Container container = getContentPane();
				if (arg0.getSource() == buttonOne) { // 获取当前组件的变量名
					container.setBackground(Color.blue);
				}
			}
		});
		buttonTwo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str = arg0.getActionCommand(); // 获取监听事件源的名称字符串
				if (str == "melody") {
					System.exit(0);
				}
			}
		});
		buttonThree.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getSource() == buttonThree) {
					JOptionPane.showMessageDialog(null,
							"你点击的按钮是" + arg0.getActionCommand());
					// 面板信息框
				}
			}
		});
		setBounds(350, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ActionListen();
	}
}