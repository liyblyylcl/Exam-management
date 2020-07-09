package com.lhr.main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;

import com.lhr.share.PlaceCenter;
import com.lhr.student.Student;
import com.lhr.teacher.TeacherMainJieMian;

public class SDMSlogin extends JFrame implements ActionListener {

	JPanel imagePanel, jp, jp1, jp2;
	JLabel jil, jl1, jl2, jl3, jl4;
	JButton jb1, jb2;
	ImageIcon background, im1;
	public static JTextField jtf;
	JPasswordField jpf;
	JComboBox jc; // 创建一个组合框对象

	public SDMSlogin() {

		jp = new JPanel();
		jp.setBounds(280, 150, 200, 50);

		jl1 = new JLabel("用  户  名 ：");
		jl1.setFont(new Font("华文彩云", Font.BOLD, 18));
		jl1.setForeground(Color.blue);
		jl1.setBounds(160, 93, 110, 40);

		jl2 = new JLabel("用户密码 ： ");
		jl2.setFont(new Font("华文彩云", Font.BOLD, 18));
		jl2.setForeground(Color.blue);
		jl2.setBounds(160, 133, 110, 40);

		jl4 = new JLabel("身份验证 ：  ");
		jl4.setFont(new Font("华文彩云", Font.BOLD, 18));
		jl4.setForeground(Color.blue);
		jl4.setBounds(160, 173, 110, 40);

		jtf = new JTextField();
		jtf.setBounds(255, 100, 120, 25);
		jpf = new JPasswordField();
		jpf.setBounds(255, 140, 120, 25);
		jpf.setEchoChar('●');
		jc = new JComboBox(); // 创建一个组合框对象
		jc.setBounds(255, 180, 120, 25); // 设置组合框的初始位置

		// 设置背景图片
		background = new ImageIcon("lhr_images\\登录背景.jpg");// 背景图片,
		// 这里是用源图片构造一个ImageIcon对象来实例化标签
		jil = new JLabel(background); // 把背景图片放在标签jil里
		jil.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());// 把标签的大小位置设置为图片的格式，使之刚好填充整个面板
		imagePanel = (JPanel) this.getContentPane();// 把内容窗格转化为JPanel,
		// 否则不能用方法setOpaque()来使内容窗格透明
		imagePanel.setOpaque(false);// 用方法setOpaque()来使内容窗格透明

		// 注册监听,jb1为登陆
		jb1 = new JButton("登陆");
		jb1.addActionListener(this);
		jb1.setBounds(165, 245, 70, 30);
		jb1.setContentAreaFilled(false);
		jb1.setForeground(Color.BLUE);
		jb1.setFont(new Font("宋体", Font.BOLD, 15));

		// 注册监听，jb2为取消
		jb2 = new JButton("取消");
		jb2.setOpaque(false);
		jb2.addActionListener(this);
		jb2.setBounds(300, 245, 70, 30);
		jb2.setContentAreaFilled(false);
		jb2.setForeground(Color.BLUE);
		jb2.setFont(new Font("宋体", Font.BOLD, 15));

		imagePanel.add(jl1);
		imagePanel.add(jtf);
		imagePanel.add(jl2);
		imagePanel.add(jpf);
		imagePanel.add(jl4);
		imagePanel.add(jc); // 将组合框组件添加到容器
		jc.addItem(new String("学生")); // 给组合框添加内容
		jc.addItem(new String("管理员"));

		jl3 = new JLabel();
		jl3.add(jb1);
		jl3.add(jb2);
		imagePanel.add(jl3);

		this.getLayeredPane().setLayout(null);
		this.getLayeredPane().add(jil, new Integer(Integer.MIN_VALUE));// 把背景图片添加到分层窗格的最底层作为背景

		this.setTitle("在线考试管理系统");
		this.setSize(600, 450);
		this.setResizable(false);
		// new PlaceCenter(this);
		this.setLocationRelativeTo(null);// 设置窗口居中显示
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {

		String username = jtf.getText();
		String password = new String(jpf.getPassword());// 获得密码

		if (e.getSource() == jb1) {

			String box = (String) jc.getSelectedItem();// 将当前所选项传给字符串box

			if (box.equals("管理员")) {

				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
					Connection cot = DriverManager
							.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\考试管理系统数据库.mdb");// 打开数据库连接，student1为数据源名称
					Statement stm = cot.createStatement();// 提交查询
					System.out.println("加载驱动OK。。。连接数据库OK。。。。。。。。。");
					String sql = "select * from AdminInformation  where username= '"
							+ username + "'";
					ResultSet rs = stm.executeQuery(sql);// 取得查询结果

					while (rs.next()) {
						String u = rs.getString("username");
						String p = rs.getString("Password");
						// System.out.println("u :"+u+"---------p :"+p);
						if ((username.equals(u)) && (password.equals(p))) {
							new TeacherMainJieMian();
							this.dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(this, "用户名或密码输入不正确！");
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
					Connection cot = DriverManager
							.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件/考试管理系统数据库.mdb");// 打开数据库连接，student1为数据源名称
					Statement stm = cot.createStatement();// 提交查询
					System.out.println("加载驱动OK。。。连接数据库OK。。。。。。。。。");
					String sql = "select * from  student  where Sno= '"
							+ username + "'";
					ResultSet rs = stm.executeQuery(sql);// 取得查询结果

					while (rs.next()) {
						String u = rs.getString("Sno");
						String p = rs.getString("Password");
						// System.out.println("u :"+u+"---------p :"+p);
						if ((username.equals(u)) && (password.equals(p))) {
							new Student();
							this.dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(this, "用户名或密码输入不正确！");
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

		if (e.getSource() == jb2) {
			try {
				new Homepage();
				this.dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {

		new SDMSlogin();
	}
}
