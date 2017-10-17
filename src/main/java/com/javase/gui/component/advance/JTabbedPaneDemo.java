package com.javase.gui.component.advance;

import java.awt.Button;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;

	// private Panel panel;
	// JPanel music;
	public JTabbedPaneDemo() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// panel=new Panel();
		// panel.setBackground(Color.RED);
		// music=new JPanel();
		// music.setBackground(Color.green);
		tabbedPane.addTab("panel", new JLabel("标签"));
		tabbedPane.addTab("music", new Button("按钮"));
		add(tabbedPane);
		setBounds(500, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTabbedPaneDemo();
	}
}
