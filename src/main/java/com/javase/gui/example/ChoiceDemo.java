package com.javase.gui.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChoiceDemo implements ItemListener, ActionListener {
	TextField name;
	CheckboxGroup cg;
	Choice career;
	List city;// 下拉列表
	Checkbox[] favorite;// 复选框

	public static void main(String[] args) {
		new ChoiceDemo().createUI();
	}

	public void createUI() {
		Frame f = new Frame("注册窗口");
		Panel p = new Panel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT, 1, 1));
		name = new TextField(12);
		cg = new CheckboxGroup();// 单选框
		Checkbox sex1 = new Checkbox("男", cg, false);
		Checkbox sex2 = new Checkbox("女", cg, false);
		Panel sp = new Panel();
		sp.add(sex1);
		sp.add(sex2);
		career = new Choice();// 下拉框
		career.add("IT技术人员");
		career.add("工商管理");
		career.add("教育");
		career.add("金融");
		city = new List(4, false);
		city.add("上海");
		city.add("北京");
		city.add("天津");
		city.add("广州");
		city.add("太原");
		city.add("石家庄");
		city.add("哈尔滨");
		city.add("三亚");
		city.add("威海");
		p.add(new Label("姓名:"));
		p.add(name);
		p.add(new Label("性别:"));
		p.add(sp);
		p.add(new Label("职业:"));
		p.add(career);
		p.add(new Label("城市:"));
		p.add(city);
		p.add(new Label("爱好:"));
		String[] sf = { "旅游", "读书", "时装", "汽车", "健美" };
		favorite = new Checkbox[sf.length];
		for (int i = 0; i < sf.length; i++) {
			favorite[i] = new Checkbox(sf[i]);
			favorite[i].addItemListener(this);
			p.add(favorite[i]);
		}
		f.add(p, "Center");
		Panel psouth = new Panel();
		psouth.setLayout(new GridLayout(1, 2));
		Button submit = new Button("提交");
		Button reset = new Button("退出");
		submit.addActionListener(this);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		psouth.add(submit);
		psouth.add(reset);
		f.add(psouth, "South");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(140, 280);
		f.setVisible(true);
		f.setLocation(300, 100);
	}

	public void itemStateChanged(ItemEvent e) {
		String s = e.getItem().toString();
		if (e.getStateChange() == ItemEvent.SELECTED) {
			System.out.println("您刚选中了项目:" + s);
		} else {
			System.out.println("您刚取消了项目:" + s);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("提交")) {
			String info = "您提交的信息如下:\n姓名:" + name.getText() + "\n性别:"
					+ cg.getSelectedCheckbox().getLabel() + "\n职业:"
					+ career.getSelectedItem() + "\n城市:"
					+ city.getSelectedItem() + "\n爱好:";
			for (Checkbox f : favorite) {
				info += f.getState() ? (f.getLabel() + ".") : "";
			}
			System.out.println(info);
		}
	}
}
