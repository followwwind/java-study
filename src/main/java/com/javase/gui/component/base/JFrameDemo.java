package com.javase.gui.component.base;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame学习类
 * @author wind
 */
public class JFrameDemo {

    /**
     * 创建JFrame窗体
     */
    public static void createWindow() {
        JFrame frame = new JFrame();
        frame.setTitle("JFrame Windows");
        frame.setLayout(null);// 设置布局
        // frame.setBackground(Color.green); 窗口无法设置背景颜色
        Container container = frame.getContentPane(); // 返回当前窗体的面板对象
        container.setBackground(Color.green);
        frame.setVisible(true);
        frame.setBounds(300, 300, 300, 300);
		/*
		 * setLocation();确定组件的位置 setSize( );确定组件的大小
		 */
        // frame.setEnabled(false);
        frame.setIconImage(new ImageIcon("src/main/resources/image/icon.png").getImage()); // 设置窗体图标
        frame.setResizable(false); // 设置是否可以改变窗口的大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置单击关闭图标按钮后的响应
    }

    /**
     * 设置JFrame底层背景图片
     */
    public static void setBg(){
        JFrame frame = new JFrame("Set Bg");
        // 这是背景图片
        ImageIcon img = new ImageIcon("src/main/resources/image/back.jpg");
        // 将背景图放在标签里。
        JLabel imgLabel = new JLabel(img);
        // 注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
        frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        // 设置背景标签的位置
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        Container cp = frame.getContentPane();
        cp.setLayout(new FlowLayout());
        // 注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
        cp.add(new JButton("button"));
        ((JPanel) cp).setOpaque(false);
        frame.setSize(500, 580);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
//        createWindow();
        setBg();
    }
}
