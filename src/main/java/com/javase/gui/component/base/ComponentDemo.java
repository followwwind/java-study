package com.javase.gui.component.base;

import javax.swing.*;
import java.awt.*;

/**
 * java swing常用组建demo
 * @author wind
 */
public class ComponentDemo {
    private static JFrame frame = new JFrame();

    public static void JButtonDemo() {
        frame.setTitle("JButton");
        frame.setLayout(new FlowLayout());
        JButton b1 = new JButton("button"); // 创建按钮
        JButton b2 = new JButton(new ImageIcon("image/icon.png"));
        JButton b3 = new JButton("button", new ImageIcon("image/icon.png"));
        JButton b4 = new JButton("button");
        b4.setFont(new Font("隶书", Font.ITALIC, 20)); // 设置字体大小
        b4.setBackground(Color.BLACK); // 设置按钮背景色
        b4.setForeground(Color.red); // 设置字体颜色
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.setVisible(true);
        frame.setBounds(300, 300, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置单击关闭图标按钮后的响应
    }

    public static void JLabelDemo() {
        frame.setTitle("JLabel");
        frame.setLayout(new FlowLayout());
        JLabel b1 = new JLabel("label以文字的形式存在,并设置字体样式"); // 创建标签
        b1.setFont(new Font("Dialog", Font.ITALIC, 30)); // 设置字体样式
        b1.setForeground(Color.blue); // 设置字体颜色
        b1.setToolTipText("label"); // 设置控件提示信息
        JLabel b2 = new JLabel("label以文字和图片的形式存在", new ImageIcon(
                "image/icon.png"), SwingConstants.LEFT);
        // SwingConstants.CENTER 居中对齐
        // new JLabel()中第三个参数为horizontalAlignment为水平对齐
        JLabel b3 = new JLabel();
        b3.setText("label以文字和图片的形式存在底部");
        b3.setIcon(new ImageIcon("image/icon.png"));
        b3.setHorizontalTextPosition(SwingConstants.CENTER);// 设置标签内容的水平对齐方式
        b3.setVerticalTextPosition(SwingConstants.BOTTOM);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.setVisible(true);
        frame.setBounds(300, 300, 600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置单击关闭图标按钮后的响应
    }

    public static void JTextFieldDemo() {
        frame.setTitle("JTextField");
        frame.setLayout(new FlowLayout());
        JTextArea t1 = new JTextArea(10, 10); // 文本域
        // t1.setEditable(false); //设置不可编辑
        JTextField t2 = new JTextField(20); // 文本框
        JTextField t3 = new JTextField("请在这里输入文字");
        JPasswordField t4 = new JPasswordField(20); // 密码输入框
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.setVisible(true);
        frame.setBounds(300, 300, 300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置单击关闭图标按钮后的响应
    }

    public static void main(String[] args) {
        JButtonDemo();
        // JLabelDemo();
        // JTextFieldDemo();
    }
}
