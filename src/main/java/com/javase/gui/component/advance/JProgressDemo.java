package com.javase.gui.component.advance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JProgressDemo implements ActionListener, ChangeListener {
	JFrame frame;
	JProgressBar progressbar;
	JLabel label;
	Timer timer;
	JButton b;
	JButton stop;
	public JProgressDemo() {
		frame = new JFrame("install");
		frame.setLayout(new BorderLayout());
		label = new JLabel("progress",SwingConstants.CENTER);
		progressbar = new JProgressBar();
		progressbar.setOrientation(JProgressBar.HORIZONTAL);
		progressbar.setMinimum(0);
		progressbar.setMaximum(100);
		progressbar.setValue(0);
		//progressbar.setStringPainted(true);
		progressbar.addChangeListener(this);
		progressbar.setPreferredSize(new Dimension(300, 10));
		progressbar.setBorderPainted(false);
		progressbar.setBackground(Color.pink);
		JPanel progressPane = new JPanel();
		progressPane.add(progressbar);
		progressPane.setPreferredSize(new Dimension(300, 10));
		JPanel panel = new JPanel();
		b = new JButton("install");
		stop = new JButton("pause");
		b.setForeground(Color.blue);
		b.addActionListener(this);
		stop.addActionListener(this);
		panel.add(b);
		panel.add(stop);
		// timer=new Timer(100,this);
		timer = new Timer(1000/10, this);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(progressPane, BorderLayout.CENTER);
		frame.add(label, BorderLayout.SOUTH);
		// frame.pack();
		frame.setBounds(100, 100, 400, 130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			timer.start();
		}
		if (e.getSource() == stop) {
			timer.stop();
		}
		if (e.getSource() == timer) {
			int value = progressbar.getValue();
			if (value < 100) {
				progressbar.setValue(++value);
			} else {
				timer.stop();
				frame.dispose();
			}
		}
	}

	public void stateChanged(ChangeEvent e) {
		int value = progressbar.getValue();
		if (e.getSource() == progressbar) {
			label.setText("current progress:" + Integer.toString(value) + "%");
			label.setForeground(Color.blue);
		}
	}

	public static void main(String[] args) {
		new JProgressDemo();
	}
}