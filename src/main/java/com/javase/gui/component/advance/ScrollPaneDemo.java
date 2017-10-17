package com.javase.gui.component.advance;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScrollPaneDemo extends JFrame {
	// private JScrollBar bar;
	private Button[] button;
	private JPanel panel;
	private ScrollPane scrollPane;
	private static final long serialVersionUID = 1L;

	ScrollPaneDemo() {
		panel = new JPanel(new GridLayout(10, 5));
		button = new Button[50];
		for (int i = 0; i < button.length; i++) {
			button[i] = new Button("按钮" + i);
			panel.add(button[i]);
		}
		scrollPane = new ScrollPane();
		scrollPane.add(panel);
		add(scrollPane, "Center");
		setBounds(300, 300, 200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ScrollPaneDemo();
	}
}
