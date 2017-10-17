package com.javase.gui.component.advance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class JTextAreaDemo {
	public static void main(String[] args) {
		JFrame f = new JFrame("留言板");
		JTextArea message = new JTextArea(20, 20);
		f.add(new JLabel("请您留言"), "North");
		f.add(message, "Center");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 6));
		String[] string = { "剪切", "复制", "粘贴", "删除", "提交", "清除" };
		String[] buttonActionCommands = { "CUT", "COPY", "PASTE", "DELETE",
				"SUBMIT", "RESET" };
		JButton button[] = new JButton[6];
		OuterMonitor om = new OuterMonitor(message, button);
		for (int i = 0; i < string.length; i++) {
			button[i] = new JButton(string[i]);
			button[i].setActionCommand(buttonActionCommands[i]);
			if (i < 4) {
				button[i].setEnabled(false);
			}
			button[i].addActionListener(om);
			p.add(button[i]);
		}
		message.addMouseMotionListener(om);
		f.add(p, "North");
		f.setSize(400, 150);
		f.setLocation(300, 100);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class OuterMonitor extends MouseMotionAdapter implements ActionListener {
	private JTextArea msg;
	private JButton buttons[];
	private String clipBoard = "";

	public OuterMonitor(JTextArea msg, JButton buttons[]) {
		this.msg = msg;
		this.buttons = buttons;
	}

	public void setClipBoard(String text) {
		this.clipBoard = text;
	}

	public void actionPerformed(ActionEvent e) {
		int position = msg.getSelectionStart();
		String s = e.getActionCommand();
		if (s.equals("RESET")) {
			msg.setText("");
		} else if (s.equals("SUBMIT")) {
			System.out.println("你的留言为:\n" + msg.getText());
		} else if (s.equals("COPY")) {
			clipBoard = msg.getSelectedText();
			msg.setSelectionStart(msg.getSelectionEnd());
		} else if (s.equals("CUT")) {
			clipBoard = msg.getSelectedText();
			this.delete();
		} else if (s.equals("PASTE")) {
			String content = msg.getText();
			String alter = content.substring(0, position) + clipBoard
					+ content.substring(position);
			msg.setText(alter);
		} else if (s.equals("DELETE")) {
			this.delete();
		}
		this.switchButtons();
	}

	public void delete() {
		int start = msg.getSelectionStart();
		int end = msg.getSelectionEnd();
		String content = msg.getText();
		String alter = content.substring(0, start) + content.substring(end);
		msg.setText(alter);
	}

	public void switchButtons() {
		boolean cliped = (clipBoard != null) && (clipBoard.length() > 0);
		buttons[2].setEnabled(cliped);
		boolean selected = msg.getSelectionEnd() != msg.getSelectionStart();
		buttons[0].setEnabled(selected);
		buttons[1].setEnabled(selected);
		buttons[3].setEnabled(selected);
	}

	public void mouseDragged(MouseEvent m) {
		this.switchButtons();
	}
}
