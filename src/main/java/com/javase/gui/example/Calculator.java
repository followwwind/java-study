package com.javase.gui.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button button[];
	private String s[] = { "1", "2", "3", "+", "sqrt", "4", "5", "6", "-", "%",
			"7", "8", "9", "*", "1/x", "0", "+/-", ".", "/", "=" };
	private JPanel panel, num;
	private TextField text;
	private StringBuffer str_display = new StringBuffer();
	private boolean bool = true;// 小数点开关控制
	private String str_oper = ""; // 运算符
	private String str_result; // 结果显示
	private double num1;
	private double num2;
	private boolean b_sub, b_mul, b_div; // 运算符开关控制

	public Calculator() {
		super("计算器");
		Container c = getContentPane();
		setLayout(new FlowLayout());
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		JMenuBar mb = new JMenuBar();
		//System.out.println("编辑");
		JMenu m1 = new JMenu("编辑");
		JMenu m2 = new JMenu("视图");
		JMenu m3 = new JMenu("帮助");
		JMenuItem m11 = new JMenuItem("复制");
		JMenuItem m12 = new JMenuItem("粘贴");
		m1.add(m11);
		m1.add(m12);
		p.add(m1);
		p.add(m2);
		p.add(m3);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		setJMenuBar(mb);
		add(p, "North");
		text = new TextField(20);
		c.add(text);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		Button b1 = new Button("Backspace");
		Button b2 = new Button("CE");
		Button b3 = new Button("C");
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		add(panel);
		num = new JPanel();
		num.setLayout(new GridLayout(4, 5, 1, 1));
		button = new Button[s.length];
		AA A = new AA();
		b1.addActionListener(A);
		b2.addActionListener(A);
		b3.addActionListener(A);
		for (int i = 0; i < s.length; i++) {
			button[i] = new Button(s[i]);
			num.add(button[i]);
			button[i].addActionListener(A);
		}
		add(num, "Center");
		setSize(220, 250);
		//setLocation(300, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new Calculator();
	}

	private class AA implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String temp = e.getActionCommand();
			if (temp.equalsIgnoreCase("1")) {
				str_display.append("1");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("2")) {
				str_display.append("2");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("3")) {
				str_display.append("3");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("4")) {
				str_display.append("4");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("5")) {
				str_display.append("5");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("6")) {
				str_display.append("6");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("7")) {
				str_display.append("7");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("8")) {
				str_display.append("8");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("9")) {
				str_display.append("9");
				text.setText(str_display.toString());
			} else if (temp.equalsIgnoreCase("0")) {
				if (str_display.length() != 0) {
					str_display.append("0");
					text.setText(str_display.toString());
				}
			} else if (temp.equalsIgnoreCase(".")) {
				if (bool) {
					if (str_display.length() != 0) {
						str_display.append(".");
						text.setText(str_display.toString());
						bool = false;
					}
				}
			} else if (temp.equalsIgnoreCase("C")) {
				text.setText("");
				str_oper = "";
				str_display = new StringBuffer("");
				str_result = null;
				num1 = 0;
				num2 = 0;
				bool = true;
				b_sub = false;
				b_mul = false;
				b_div = false;
			} else if (temp.equalsIgnoreCase("Backspace")) {
				if (str_display.length() != 0) {
					str_display.deleteCharAt(str_display.length() - 1);
					text.setText(str_display.toString());
				}
			} else if (temp.equalsIgnoreCase("+")) {
				str_oper = "+";
				if (!(str_display.toString() == "")) {
					num1 = Double.parseDouble(str_display.toString());
					str_display = new StringBuffer("");
				}
				if (!(str_result == null)) {
					num1 = Double.parseDouble(str_result);
					str_result = null;
				}
				text.setText(String.valueOf(num1));
				bool = true;
			} else if (temp.equalsIgnoreCase("-")) {
				str_oper = "-";
				String disStr = str_display.toString();
				if (!b_sub && !"".equals(disStr)) {
					num1 = Double.parseDouble(disStr);
					text.setText(String.valueOf(num1));
					str_display = new StringBuffer("");
					b_sub = true;
				} else {
					if (!(str_display.toString() == "")) {
						num1 = Double.parseDouble(str_display.toString());
						str_display = new StringBuffer("");
					}
					if (!(str_result == null)) {
						num1 = Double.parseDouble(str_result);
						str_result = null;
					}
					text.setText(String.valueOf(num1));
				}
				bool = true;
			} else if (temp.equalsIgnoreCase("*")) {
				str_oper = "*";
				if (!b_mul && !(str_display.toString() == "")) {
					num1 = Double.parseDouble(str_display.toString());
					text.setText(String.valueOf(num1));
					str_display = new StringBuffer("");
					b_mul = true;
				} else {
					if (!(str_display.toString() == "")) {
						num1 = Double.parseDouble(str_display.toString());
						str_display = new StringBuffer("");
					}
					if (!(str_result == null)) {
						num1 = Double.parseDouble(str_result);
						str_result = null;
					}
					text.setText(String.valueOf(num1));
				}
				bool = true;
			} else if (temp.equalsIgnoreCase("/")) {
				str_oper = "/";
				if (!b_div && !(str_display.toString() == "")) {
					num1 = Double.parseDouble(str_display.toString());
					text.setText(String.valueOf(num1));
					str_display = new StringBuffer("");
					b_div = true;
				} else {
					if (!(str_display.toString() == "")) {
						if (Double.parseDouble(str_display.toString()) == 0) {
							// "除数不能为零";
							str_display = new StringBuffer("");
						} else {
							num1 = Double.parseDouble(str_display.toString());
							str_display = new StringBuffer("");
						}
					}
					if (!(str_result == null)) {
						num1 = Double.parseDouble(str_result);
						str_result = null;
					}
					text.setText(String.valueOf(num1));
				}
				bool = true;
			} else if (temp.equalsIgnoreCase("=")) {
				if (str_oper.equals("+")) {
					num2 = Double.parseDouble(str_display.toString());
					str_result = String.valueOf((num1 + num2));
					text.setText(str_result);
					str_display = new StringBuffer("");
					str_oper = "";
				}

				if (str_oper.equals("-")) {
					num2 = Double.parseDouble(str_display.toString());
					str_result = String.valueOf((num1 - num2));
					text.setText(str_result);
					str_display = new StringBuffer("");
					str_oper = "";
				}

				if (str_oper.equals("*")) {
					num2 = Double.parseDouble(str_display.toString());
					str_result = String.valueOf((num1 * num2));
					text.setText(str_result);
					str_display = new StringBuffer("");
					str_oper = "";
				}

				if (str_oper.equals("/")) {
					num2 = Double.parseDouble(str_display.toString());
					if (!(num2 == 0)) {
						str_result = String.valueOf((num1 / num2));
						text.setText(str_result);
					} else {
						// Toast.makeText(CalculatorActivity.this,
						// "除数不能为零", Toast.LENGTH_LONG).show();
					}
					str_display = new StringBuffer("");
					str_oper = "";
				}
			}
		}
	}
}
