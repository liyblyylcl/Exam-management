package com.lhr.student;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


import com.lhr.main.SDMSlogin;
import com.lhr.share.ImageJPanel;
import com.lhr.share.PlaceCenter;

public class Student extends JFrame {

	JLabel jl;
	JButton jb1, jb2, jb3;
	JPanel jp1;
	ImageIcon im, im1, im2;

	public Student() throws IOException {

		// **************** 调用方法设置背景图片 *********************
		ImageJPanel jp = new ImageJPanel("lhr_images/1.jpg");	
		jp.setLayout(null);

		// ********************* 设置标签 **************************
		jl = new JLabel("欢迎来到在线考试系统");
		jl.setBounds(180, 0, 500, 100);
		jl.setForeground(Color.RED);
		jl.setFont(new Font("浪漫雅圆", Font.BOLD, 30));

		// *********************** 参加考试按钮 ********************
		im = new ImageIcon("lhr_images\\参加考试.gif");
		jb1 = new JButton(im);
		jb1.setBounds(270, 400, im.getIconWidth(), im.getIconHeight());
		jb1.setToolTipText("点击进入在线考试系统");
		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new JoinExam();
				Student.this.dispose();

			}
		});

		// *********************** 查询分数按钮 ********************
		im2 = new ImageIcon("lhr_images\\查询分数.gif");
		jb2 = new JButton(im2);
		jb2.setBounds(270, 450, im2.getIconWidth(), im2.getIconHeight());
		jb2.setToolTipText("点击可以查询考生的成绩");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new QueryGrade();
				Student.this.dispose();

			}
		});

		// ***************** 返回按钮 *************************
		jb3 = new JButton(new ImageIcon("lhr_images\\1168.gif"));
		jb3.setContentAreaFilled(false);
		jb3.setBounds(570, 450, 100, 45);
		jb3.setToolTipText("点击可以返回到上一页");
		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SDMSlogin();
				Student.this.dispose();

			}
		});

		// ******************** 添加组件 *************************
		jp.add(jl);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		this.add(jp);

		// ********************** 设置jframe的属性 ******************
		this.setIconImage((new ImageIcon("lhr_images\\校徽.jpg")).getImage()); // 设置标题图标
		this.setTitle("考试系统");
		
		this.setSize(700,550);
		this.setResizable(false);// 控制窗体大小
		this.setLocationRelativeTo(null);//居中显示
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * *************** 主方法 ****************************
	 */
	public static void main(String[] args) throws IOException {

		new Student();
	}

}
