package com.javase.thread.base;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockThread extends Thread{
	JFrame frame;
	JLabel label;

	ClockThread() {
		frame = new JFrame("数字时钟");
		label = new JLabel("clock");
		label.setHorizontalAlignment(JLabel.CENTER); // 将标签置于窗口中间
		frame.add(label);
		frame.setBounds(500, 300, 150, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void run() {
		while (true) {
			label.setText(this.getTime());
			try {
				Thread.sleep(1000);// 1000ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getTime() {
		Calendar c = new GregorianCalendar();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		int h = c.get(Calendar.HOUR_OF_DAY);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		String pmo = month < 10 ? "0" : "";
		String pd = day < 10 ? "0" : "";
		String ph = h < 10 ? "0" : "";
		String pm = m < 10 ? "0" : "";
		String ps = s < 10 ? "0" : "";
		return year + "-" + pmo + month + "-" + pd + day + "-" + ph + h + "-"
				+ pm + m + "-" + ps + s;
	}

	public static void main(String[] args) {
		new ClockThread().start();
	}
}