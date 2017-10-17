package com.javase.gui.component.advance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JMenuDemo extends JFrame {
	/**
	 * 
	 */
	JMenuBar bar;
	JMenu file;
	JMenu help;
	private static final long serialVersionUID = 1L;

	JMenuDemo() {
		setTitle("记事本");
		setPosition();
		setBounds(300, 200, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setPosition() {
		bar = new JMenuBar(); // 菜单栏
		// 一级菜单
		file = new JMenu("文件");
		JMenu edit = new JMenu("编辑");
		help = new JMenu("帮助");
		JMenu form = new JMenu("格式");
		// file之下的二级菜单
		JMenuItem newCreate = new JMenuItem("新建");
		JMenuItem open = new JMenuItem("打开");
		JMenuItem save = new JMenuItem("保存");
		JMenuItem saveAs = new JMenuItem("另存为");
		JMenuItem exit = new JMenuItem("退出");
		file.add(newCreate);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.addSeparator();
		file.add(exit);
		// form之下的二级菜单
		JCheckBoxMenuItem binary = new JCheckBoxMenuItem("二进制");
		JMenuItem font = new JMenuItem("字体");
		form.add(binary);
		form.add(font);
		// help之下的二级菜单
		JMenuItem aboutNotepad = new JMenuItem("about notepad");
		help.add(aboutNotepad);
		// 监听事件，响应各个菜单的功能
		newCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// JFrame f=new JFrame();
				// f.setVisible(true);
				new JMenuDemo();
				JOptionPane.showMessageDialog(null, "新建一个窗口");
			}
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		aboutNotepad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "这是一个记事本");

			}
		});
		// 将一级菜单添加到菜单栏
		bar.add(file);
		bar.add(edit);
		bar.add(form);
		bar.add(help);
		// setJMenuBar(bar); 设置菜单项 将菜单添加到JFrame窗口顶端，从左上端开始
		add(bar, "North");
		JTextArea area = new JTextArea("", 20, 20);
		add(area, "Center");
	}

	public static void main(String[] args) {
		new JMenuDemo();
	}
}
