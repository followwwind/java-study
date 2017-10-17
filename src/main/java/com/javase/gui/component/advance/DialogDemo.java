package com.javase.gui.component.advance;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo implements ActionListener {
	private JButton logOn, register, help, exit;
	private JLabel label;
	private JPanel p;
	private JDialog d1, d2;
	private JTextField t;
	private JPasswordField ps;

	public DialogDemo() {
		JFrame frame = new JFrame("注册窗口");
		logOn = new JButton("登陆");
		register = new JButton("注册");
		help = new JButton("帮助");
		exit = new JButton("退出");
		logOn.addActionListener(this);
		exit.addActionListener(this);
		p = new JPanel();
		p.setLayout(new GridLayout(1, 4));
		p.add(logOn);
		p.add(register);
		p.add(help);
		p.add(exit);
		frame.add(p, "North");
		label = new JLabel("您尚未登陆");
		d1 = this.creatLoginDialog(frame);
		d2 = this.creatQuitDialog(frame);
		frame.add(label, "Center");
		frame.setBounds(300, 300, 400, 150);
		frame.setVisible(true);
	}

	public JDialog creatLoginDialog(JFrame f) {
		JDialog d = new JDialog(f, "登陆对话框", true);
		JLabel l = new JLabel("请输入注册信息");
		JPanel pa = new JPanel();
		pa.setLayout(new GridLayout(2, 1));
		pa.add(new JLabel("用户名:"));
		pa.add(new JLabel("密码:"));
		JPanel pc = new JPanel();
		pc.setLayout(new GridLayout(2, 1));
		t = new JTextField();
		ps = new JPasswordField();
		ps.setEchoChar('*');
		pc.add(t);
		pc.add(ps);
		JPanel pb = new JPanel();
		pb.setLayout(new GridLayout(1, 2));
		JButton b1 = new JButton("提交");
		JButton b2 = new JButton("取消");
		b1.setActionCommand("submitLogin");
		b2.setActionCommand("cancelLogin");
		b1.addActionListener(this);
		b2.addActionListener(this);
		pb.add(b1);
		pb.add(b2);
		d.add(l, "North");
		d.add(pa, "West");
		d.add(pc, "Center");
		d.add(pb, "South");
		d.setSize(180, 120);
		d.setLocation(400, 200);
		return d;
	}

	public JDialog creatQuitDialog(JFrame f) {
		JDialog d = new JDialog(f, "退出对话框", true);
		JLabel l = new JLabel("你确定要退出程序吗？");
		JPanel p = new JPanel();
		JButton confirm = new JButton("确定");
		JButton cancel = new JButton("取消");
		confirm.setActionCommand("confirmQuit");
		cancel.setActionCommand("cancelQuit");
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		p.add(confirm);
		p.add(cancel);
		d.setSize(160, 120);
		d.setLocation(400, 200);
		d.add(l, "Center");
		d.add(p, "South");
		return d;
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("登陆")) {
			d1.setVisible(true);
		} else if (s.equals("退出")) {
			this.quit();
		} else if (s.equals("confirmQuit")) {
			System.exit(0);
		} else if (s.equals("cancelQuit")) {
			d2.setVisible(false);
		} else if (s.equals("submitLogin")) {
			String name = t.getText();
			@SuppressWarnings("deprecation")
			String password = ps.getText();
			if (name.equals("Corejava") && password.equals("Tiger")) {
				label.setText("欢迎您:" + name + "用户");
			} else {
				label.setText("验证失败，错误的用户名/密码!");
				d2.setVisible(false);
			}
		} else if (s.equals("cancelLogin")) {
			d1.setVisible(false);
		}
	}

	public void quit() {
		d2.setVisible(true);
	}

	public static void main(String[] args) {
		new DialogDemo();
	}
}
