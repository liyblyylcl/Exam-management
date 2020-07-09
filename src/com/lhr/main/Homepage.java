package com.lhr.main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import com.lhr.share.*;
import com.lhr.student.AePlayWave;

public class Homepage extends JFrame implements ActionListener {

	JLabel jl, jl1, background, jl2, jl3;
	JButton jb, jbexit, startjb;
	JPanel jp, jp1, imagePanel;
	ImageIcon imgBackground, im, im1;
	JTextArea textarea;
	static AePlayWave apw;

	/**
	 * ***************************构造方法*************************
	 */
	public Homepage() throws IOException {

		// ******************** 设置背景图片 ******************//
		BackgroundPicture.setJFrameBackgroundPicture(this,
				"lhr_images\\首页背景.jpg");
		
		ImageJPanel  imageJPanel=new ImageJPanel("lhr_images\\首页背景.jpg");//设置背景图片

		// 设置标签
		jl = new JLabel("欢迎来到考试管理系统");
		jl.setBounds(270, 300, 600, 50);
		jl.setForeground(Color.blue);
		jl.setFont(new Font("黑体", Font.BOLD, 40));

		jl1 = new JLabel(
				"Welcome   to   the  examination   management   system " + "!");
		jl1.setFont(new Font("Arial", Font.BOLD, 18));
		jl1.setForeground(Color.red);
		jl1.setBounds(250, 350, 600, 50);

		jl2 = new JLabel("安博培训小组：Sun夏");
		jl2.setFont(new Font("黑体", Font.BOLD, 25));
		jl2.setForeground(Color.red);
		jl2.setBounds(100, 50, 600, 50);

		// 注册监听
		im = new ImageIcon("lhr_images\\1020.gif");
		jb = new JButton(im);
		jb.setSize(im.getIconWidth() - 10, im.getIconHeight());
		jb.setLocation(820, 620);
		jb.setContentAreaFilled(false);
		// jb.setBorderPainted(false);//去掉按钮边框
		jb.addActionListener(this);

		jbexit = new JButton("停止音乐");
		jbexit.setBounds(100, 620, 100, 30);
		jbexit.setContentAreaFilled(false);
		jbexit.addActionListener(this);
		jbexit.setFocusable(false);
		jbexit.setForeground(Color.BLUE);
		jbexit.setFont(new Font("宋体", Font.BOLD, 15));

		startjb = new JButton("播放音乐");
		startjb.setBounds(100, 660, 100, 30);
		startjb.setContentAreaFilled(false);
		startjb.setFocusable(false);//取消获得焦点
		startjb.addActionListener(this);
		startjb.setForeground(Color.BLUE);
		startjb.setFont(new Font("宋体", Font.BOLD, 15));

		/******************************* 添加组件 **************************/
		imageJPanel.setLayout(null);
		imageJPanel.add(jl2);
		imageJPanel.add(jl1);
		imageJPanel.add(jb);
		imageJPanel.add(jbexit);
		imageJPanel.add(startjb);
		imageJPanel.add(jl);
		this.add(imageJPanel);

		//************************** 设置窗口属性 ***************************//
		this.setIconImage((new ImageIcon("images\\校徽.jpg")).getImage()); // 设置标题图标
		this.setTitle("考试管理系统");
		this.setSize(1000, 750);
		this.setResizable(false);// 控制窗体大小
		this.setLocationRelativeTo(null);//居中显示

//		new PlaceCenter(this);// ******* 调用方法使窗口居中******//
		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) throws IOException {

		new Homepage();
		apw = new AePlayWave("./Informations/1.wav");
		apw.start();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jb) {

			new SDMSlogin();
			this.dispose();
		}
		if (e.getSource() == jbexit) {
			apw.stop();

		}
		if (e.getSource() == startjb) {
			apw = new AePlayWave("./Informations/1.wav");
			apw.start();

		}

	}

}
