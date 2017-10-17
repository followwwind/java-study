package com.javase.gui.component.base;

import java.awt.FlowLayout;

import javax.swing.JApplet;

/**
 * window需要将编辑器编码改为GBK，否则会乱码
 * @author wind
 */
public class AppletDemo extends JApplet {

	public void init() {
		setLayout(new FlowLayout());
	}
}
