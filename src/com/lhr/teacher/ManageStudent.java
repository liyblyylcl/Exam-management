package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.share.DBConnect;
import com.lhr.share.ImageJPanel;

import java.sql.*;
import java.util.Vector;

public class ManageStudent implements ActionListener {

	JLabel JL = new JLabel("修改考生信息", JLabel.CENTER);// 使用文本创建一个标签对象
	JLabel JLNumber = new JLabel("请输入要修改的考生学号:");// 使用文本创建一个标签对象
	JTextField JTNumber = new JTextField();// 创建一个文本框对象

	JButton JBSet = new JButton("查询");// 创建按钮对象
	JButton JBNext = new JButton("重置");
	JButton jb1 = new JButton("修改");

	JTextArea resultarea = new JTextArea(100, 100);
	String sql = ""; // 定义一个字符串

	ImageJPanel jp = new ImageJPanel("lhr_images/208.jpg");
	Statement stm = DBConnect.dataBaseConnect();

	public ManageStudent() // 创建SetGrade构造函数
	{

		jp.setLayout(null);// 设置窗口布局管理器
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		JL.setBounds(100, 30, 200, 40);// 设置标签的初始位置
		jp.add(JL);// 将标签添加到容器

		JLNumber.setBounds(80, 80, 300, 20);// 设置学号标签的初始位置
		jp.add(JLNumber);// 将学号标签添加到容器
		JLNumber.setForeground(Color.GREEN);
		JLNumber.setFont(new Font("宋体", Font.PLAIN, 15));
		JTNumber.setBounds(260, 80, 80, 20);// 设置文本框的初始位置
		jp.add(JTNumber);// 将文本框添加到容器

		JBSet.setBounds(65, 120, 70, 20);// //设置查询按钮的初始位置
		jp.add(JBSet);// 将查询按钮添加到容器
		JBSet.addActionListener(this);// 给按钮添加监听器
		JBNext.setBounds(175, 120, 70, 20);// 设置重置按钮的初始位置
		jp.add(JBNext);// 将重置按钮添加到容器
		JBNext.addActionListener(this);// 给按钮添加监听器

		jb1.setBounds(285, 120, 70, 20);// 设置返回按钮的初始位置
		jp.add(jb1);// 将返回按钮添加到容器
		jb1.addActionListener(this);// 给按钮添加监听器

		jp.add(resultarea);
		resultarea.setBounds(60, 180, 300, 300);
		resultarea.setFont(new Font("宋体", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setEditable(false);
		resultarea.setOpaque(false);
		resultarea.setBorder(BorderFactory.createLineBorder(Color.black));
		jp.add(resultarea);

		jp.setBounds(10, 10, 500, 400);// 设置窗口尺寸大小
		jp.setLocation(500, 300);
		jp.setVisible(true);// 设置窗口的可见性

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // 处理"查询"事件
		{
			String snumber = JTNumber.getText();// 将文本框中包含的文本传给字符串snumber

			sql = "select * from  student  where Sno='" + snumber + "'";// 检索出Id等于snumber的学生的所有信息

			try // 异常处理
			{
				
				ResultSet rs = stm.executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);
				if (rs.next()) // 判断结果是否存在
				{
					resultarea.setText(" 学号：");
					resultarea.append(rs.getString("Sno") + "\n" + " 姓名：");
					resultarea.append(rs.getString("Sname") + "\n" + " 性别：");
					resultarea.append(rs.getString("Ssex") + "\n" + " 生日：");
					resultarea.append(rs.getString("Sbirthday") + "\n"
							+ " QQ  ： ");
					resultarea.append(rs.getString("Sqq") + "\n" + " 手机号：");
					resultarea.append(rs.getString("Smphone") + "\n" + " 邮箱：");
					resultarea.append(rs.getString("Smailbox") + "\n"
							+ " 家庭住址：");
					resultarea.append(rs.getString("Saddress") + "\n" + " 学院：");
					resultarea.append(rs.getString("Sschool") + "\n" + " 专业：");
					resultarea.append(rs.getString("Sdept") + "\n" + " 班级：");
					resultarea.append(rs.getString("Sclass") + "\n" + " 宿舍号：");
					resultarea.append(rs.getString("Dno") + "\n" + " 入住时间：");
					resultarea.append(rs.getString("Scheckin"));

				} else {
					JOptionPane.showMessageDialog(null, "此用户不存在!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// 处理"重置"事件
		{
			JTNumber.setText(null);// 设置文本的text值为null
			resultarea.setText(null);
		}
		if (e.getSource() == jb1) {
			new xiugaistudent();

		}
	}

}
