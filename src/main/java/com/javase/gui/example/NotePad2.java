package com.javase.gui.example;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class NotePad2 {

	// protected static final String string_separator =
	// System.getProperty("string_separator");
	private Frame f;
	private TextArea t;

	public static void main(String[] args) {
		new NotePad2().init();
	}

	public void init() {
		f = new Frame("My Notepad");
		MenuBar mb = new MenuBar();
		Menu file = new Menu("文件");
		MenuItem open = new MenuItem("打开");
		file.add(open);
		mb.add(file);
		f.setMenuBar(mb);
		t = new TextArea();
		f.add(t, "Center");
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// dialog=new Dialog(f,"对话框");
				// dialog.setVisible(true);
				JFileChooser chooser = new JFileChooser();
				// chooser.setVisible(true);//文件过滤
				// FileNameExtensionFilter filter=new
				// FileNameExtensionFilter("JPG&GIF Images", "jpg","gif");
				// chooser.setFileFilter(filter);
				// int returnVal=chooser.showOpenDialog(f);
				// if(returnVal==JFileChooser.APPROVE_OPTION){
				// System.out.println("You choose to open this file:"+chooser.getSelectedFile().getName()
				// );
				// }
				int returnVal = chooser.showOpenDialog(f);
				if (returnVal == JFileChooser.CANCEL_OPTION) {
					System.out.println("没有选取文件");
					return;

				}
				File file = chooser.getSelectedFile();

				try {
					t.setText("");
					BufferedReader bufferedReader = new BufferedReader(
							new FileReader(file));
					String string = bufferedReader.readLine();
					while ((string = bufferedReader.readLine()) != null) {

						t.append(string + "\n");
					}
					bufferedReader.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(400, 200);
		f.setLocation(450, 200);
		f.setVisible(true);

	}
}
