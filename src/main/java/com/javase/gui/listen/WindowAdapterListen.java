package com.javase.gui.listen;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterListen extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WindowAdapterListen() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				// 用户试图从窗口的系统菜单中关闭窗口时调用。
				System.exit(0);
			}
		});

		setBounds(350, 100, 500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowAdapterListen();
	}
}
