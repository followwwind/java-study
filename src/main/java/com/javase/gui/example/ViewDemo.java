package com.javase.gui.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewDemo {
	private JFrame frame;
	private JButton bBrowse;
	private JButton bUpload;
	private JButton bDownload;
	private JTextField field;
	private JLabel labelPicture;
	JFileChooser fileChooser = new JFileChooser();

	public ViewDemo() {
		// TODO Auto-generated constructor stub
		frame = new JFrame();
		setPosition();
		Dimension faceSize = new Dimension(600, 600);
		// 设置窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(faceSize);
		frame.setLocation((int) (screenSize.width - faceSize.getWidth()) / 2,
				(int) (screenSize.height - faceSize.getHeight()) / 2);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void setPosition() {
		JPanel total = new JPanel();
		JPanel panelUp = new JPanel();
		JPanel panelDown = new JPanel();
		JPanel panelIcon = new JPanel();
		total.setLayout(new BorderLayout());
		panelUp.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelDown.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelIcon.setLayout(new FlowLayout(FlowLayout.LEFT));
		// 向panelUp面板添加组件
		JLabel labelUp = new JLabel("请选择上传的文件");
		field = new JTextField(20);
		bBrowse = new JButton("浏览");
		bUpload = new JButton("上传");
		bBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileChooser.setCurrentDirectory(new File("."));
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					String path = fileChooser.getSelectedFile().getPath();
					field.setText(path);
				}
			}
		});
		bUpload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String fromFileName = field.getText();
				String toFileName = System.currentTimeMillis() + ".jpg";
				write(fromFileName, toFileName);
				JOptionPane.showMessageDialog(frame, "上传成功!", "提示",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		panelUp.add(labelUp);
		panelUp.add(field);
		panelUp.add(bBrowse);
		panelUp.add(bUpload);
		// 向panelDown面板添加组件
		JLabel labelDown = new JLabel("下载下面图片");
		bDownload = new JButton("下载");
		bDownload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				fileChooser.setCurrentDirectory(new File("."));
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					String path = fileChooser.getSelectedFile().getPath();
					String fromFileName = field.getText();
					write(fromFileName, path);
					JOptionPane.showMessageDialog(frame, "下载成功!", "提示",
							JOptionPane.WARNING_MESSAGE);
					ImageIcon icon = new ImageIcon(fromFileName);
					labelPicture.setBounds(0, 300, 600, 500);
					labelPicture.setIcon(icon);

				}
			}
		});
		panelDown.add(labelDown);
		panelDown.add(bDownload);
		// 向panelIcon面板添加组件
		labelPicture = new JLabel();
		panelIcon.add(labelPicture);
		// panelIcon.setBackground(Color.red);
		// 向total面板添加组件
		total.add(panelUp, BorderLayout.NORTH);
		total.add(panelDown, BorderLayout.CENTER);
		total.add(panelIcon, BorderLayout.SOUTH);
		frame.add(total);
	}

	// fromFile是源文件,toFile是目标文件
	public void write(String fromFile, String toFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fromFile);
			fos = new FileOutputStream(toFile);
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(buf)) > 0) {
				fos.write(buf, 0, hasRead);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ViewDemo();
	}
}