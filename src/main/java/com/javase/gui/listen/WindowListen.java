package com.javase.gui.listen;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListen extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	WindowListen() {
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				/*
				 * 窗口从正常状态变为最小化状态时调用。 对于很多平台而言，已最小化的窗口将显示为窗口 iconImage
				 * 属性中所指定的图标。
				 */
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				// 用户试图从窗口的系统菜单中关闭窗口时调用。
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				// 因对窗口调用 dispose 而将其关闭时调用。
				// System.exit(0);
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		setBounds(350, 100, 500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowListen();
	}

}
