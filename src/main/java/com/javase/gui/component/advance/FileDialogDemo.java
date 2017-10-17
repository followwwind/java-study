package com.javase.gui.component.advance;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDialogDemo implements ActionListener {
	private Frame f;
	private FileDialog fload;
	private FileDialog fsave;
	private TextArea t;
	private String file = "";

	public static void main(String[] args) {
		new FileDialogDemo().init();
	}

	public void init() {
		f = new Frame("My Notepad");
		MenuBar mb = new MenuBar();
		Menu file = new Menu("文件");
		Menu help = new Menu("帮助");
		MenuItem open = new MenuItem("打开");
		MenuItem save = new MenuItem("保存");
		MenuItem saveAs = new MenuItem("另存为");
		file.add(open);
		file.add(save);
		file.add(saveAs);
		mb.add(file);
		mb.add(help);
		f.setMenuBar(mb);
		t = new TextArea();
		f.add(t, "Center");
		open.addActionListener(this);
		save.addActionListener(this);
		saveAs.addActionListener(this);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(400, 200);
		f.setLocation(450, 200);
		f.setVisible(true);
		fload = new FileDialog(f, "打开文件", FileDialog.LOAD);
		fsave = new FileDialog(f, "保存文件", FileDialog.SAVE);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("打开")) {
			fload.setVisible(true);
			String d = fload.getDirectory();
			String f = fload.getFile();
			if ((d != null) && (f != null)) {
				file = d + f;
				loadFile();
			}
		} else if (s.equals("保存")) {
			if ((file == null) || file.equals("")) {
				this.saveFileAs();
			} else {
				this.saveFile();
			}
		} else if (s.equalsIgnoreCase("另存为")) {
			this.saveFileAs();
		}
	}

	public void loadFile() {
		t.setText("");
		t.setFont(new Font("隶书", Font.ITALIC, 20));
		t.setForeground(Color.red);
		f.setTitle("My Notepad-" + file);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				t.append(s + "\n");
				System.out.print(s + "\n");
				s = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveFile() {
		String c = t.getText();
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(c);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveFileAs() {
		fsave.setVisible(true);
		String d = fload.getDirectory();
		String fd = fload.getFile();
		if ((d != null) && (f != null)) {
			file = d + fd;
			this.saveFile();
			f.setTitle("My Notepad-" + file);
		}
	}
}
