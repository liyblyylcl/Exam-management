package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.share.*;

import java.sql.*;

public class AddStudent extends JFrame implements ActionListener {

	JLabel JL = new JLabel("添 加 学生 信 息", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel JLSno = new JLabel("学号:"); // 使用文本创建一个标签对象
	JTextField JTSno = new JTextField(); // 创建一个文本框对象

	JLabel JLDno = new JLabel("宿舍号:"); // 使用文本创建一个标签对象
	JTextField JTDno = new JTextField(); // 创建一个文本框对象

	JLabel JLSname = new JLabel("姓名:"); // 使用文本创建一个标签对象
	JTextField JTSname = new JTextField(); // 创建一个文本框对象

	JLabel JLSsex = new JLabel("性别:"); // 使用文本创建一个标签对象
	ButtonGroup BG = new ButtonGroup(); // 创建一个ButtonGroup组件对象
	JRadioButton JRb1 = new JRadioButton("男");
	JRadioButton JRb2 = new JRadioButton("女");

	JLabel JLSbirthday = new JLabel("生日:"); // 使用文本创建一个标签对象
	JTextField JTSbirthday = new JTextField();

	JLabel JLSqq = new JLabel("QQ:"); // 使用文本创建一个标签对象
	JTextField JTSqq = new JTextField();

	JLabel JLSmailbox = new JLabel("邮箱:"); // 使用文本创建一个标签对象
	JTextField JTSmailbox = new JTextField();

	JLabel JLSaddress = new JLabel("家庭住址:"); // 使用文本创建一个标签对象
	JTextField JTSaddress = new JTextField();

	JLabel JLSdept = new JLabel("专业:"); // 使用文本创建一个标签对象
	JTextField JTSdept = new JTextField();

	JLabel JLScheckin = new JLabel("入学时间:"); // 使用文本创建一个标签对象
	JTextField JTScheckin = new JTextField();

	JLabel JLSmphone = new JLabel("手机号:"); // 使用文本创建一个标签对象
	JTextField JTSmphone = new JTextField();

	JLabel JLSschool = new JLabel("学院:"); // 使用文本创建一个标签对象
	JTextField JTSschool = new JTextField();

	JLabel JLSclass = new JLabel("班级:"); // 使用文本创建一个标签对象
	JTextField JTSclass = new JTextField();

	JButton JBAdd = new JButton("添加"); // 创建按钮对象
	JButton JBNext = new JButton("重置");


	String sql = ""; // 定义一个字符串
	

	ImageJPanel jp;
	

	public void setjl(JLabel jl) {

		jl.setForeground(Color.BLUE);
		jl.setFont(new Font("宋体", Font.BOLD, 15));
	}

	public AddStudent() // 创建AddStudent构造函数
	{
		
		
		
		jp = new ImageJPanel("lhr_images/201.jpg");
		jp.setLayout(null); // 设置窗口布局管理器
		JL.setBounds(100, 20, 200, 40); // 设置标签的初始位置
		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
		jp.add(JL); // 将标签添加到容器

		JLSno.setBounds(100, 70, 100, 20); // 设置学号标签的初始位置
		jp.add(JLSno); // 将学号标签添加到容器
		JTSno.setBounds(200, 70, 100, 20); // 设置文本框的初始位置
		jp.add(JTSno); // 将文本框添加到容器
		setjl(JLSno);

		JLSname.setBounds(100, 100, 100, 20); // 设置姓名标签的初始位置
		jp.add(JLSname); // 将姓名标签添加到容器
		JTSname.setBounds(200, 100, 100, 20); // 设置文本框的初始位置
		jp.add(JTSname); // 将文本框添加到容器
		setjl(JLSname);

		JLSsex.setBounds(100, 130, 100, 20); // 设置性别标签的初始位置
		jp.add(JLSsex); // 将性别标签添加到容器
		setjl(JLSsex);
		JRb1.setBounds(200, 130, 40, 20);
		JRb1.setForeground(Color.BLUE);
		JRb1.setOpaque(false);
		JRb2.setBounds(260, 130, 40, 20);
		JRb2.setForeground(Color.BLUE);
		JRb2.setOpaque(false);
		jp.add(JRb1);
		jp.add(JRb2);
		BG.add(JRb1);
		BG.add(JRb2);

		JLSbirthday.setBounds(100, 160, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSbirthday); // 将班级标签添加到容器
		setjl(JLSbirthday);
		JTSbirthday.setBounds(200, 160, 100, 20); // 设置文本框的初始位置
		jp.add(JTSbirthday); // 将文本框添加到容器

		JLSmphone.setBounds(100, 190, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSmphone); // 将班级标签添加到容器
		setjl(JLSmphone);
		JTSmphone.setBounds(200, 190, 100, 20); // 设置文本框的初始位置
		jp.add(JTSmphone);

		JLSqq.setBounds(100, 220, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSqq); // 将班级标签添加到容器
		setjl(JLSqq);
		JTSqq.setBounds(200, 220, 100, 20); // 设置文本框的初始位置
		jp.add(JTSqq);

		JLSmailbox.setBounds(100, 250, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSmailbox); // 将班级标签添加到容器
		setjl(JLSmailbox);
		JTSmailbox.setBounds(200, 250, 100, 20); // 设置文本框的初始位置
		jp.add(JTSmailbox);

		JLSschool.setBounds(100, 280, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSschool); // 将班级标签添加到容器
		setjl(JLSschool);
		JTSschool.setBounds(200, 280, 100, 20); // 设置文本框的初始位置
		jp.add(JTSschool);

		JLSdept.setBounds(100, 310, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSdept); // 将班级标签添加到容器
		setjl(JLSdept);
		JTSdept.setBounds(200, 310, 100, 20); // 设置文本框的初始位置
		jp.add(JTSdept);

		JLSclass.setBounds(100, 340, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSclass); // 将班级标签添加到容器
		setjl(JLSclass);
		JTSclass.setBounds(200, 340, 100, 20); // 设置文本框的初始位置
		jp.add(JTSclass);

		JLDno.setBounds(100, 370, 100, 20); // 设置班级标签的初始位置
		jp.add(JLDno); // 将班级标签添加到容器
		setjl(JLDno);
		JTDno.setBounds(200, 370, 100, 20); // 设置文本框的初始位置
		jp.add(JTDno);

		JLScheckin.setBounds(100, 400, 100, 20); // 设置班级标签的初始位置
		jp.add(JLScheckin); // 将班级标签添加到容器
		setjl(JLScheckin);
		JTScheckin.setBounds(200, 400, 100, 20); // 设置文本框的初始位置
		jp.add(JTScheckin);

		JLSaddress.setBounds(100, 430, 100, 20); // 设置班级标签的初始位置
		jp.add(JLSaddress); // 将班级标签添加到容器
		setjl(JLSaddress);
		JTSaddress.setBounds(200, 430, 100, 20); // 设置文本框的初始位置
		jp.add(JTSaddress);

		JBAdd.setBounds(120, 470, 70, 20); // 设置添加按钮的初始位置
		jp.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(220, 470, 70, 20); // 设置重置按钮的初始位置
		jp.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		jp.setBounds(500, 330, 420, 450); // 设置窗口尺寸大小
		jp.setVisible(true); // 设置窗口的可见性
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// 处理"添加"事件
		{
			String Sno = JTSno.getText().trim();// 将文本框中包含的文本传给字符串snumber
			String Sname = JTSname.getText().trim();// 将文本框中包含的文本传给字符串sname
			String Sclass = JTSclass.getText().trim();// 将文本框中包含的文本传给字符串sclass
			String Sqq = JTSqq.getText().trim();
			String Sbirthday = JTSbirthday.getText().trim();
			String Smailbox = JTSmailbox.getText().trim();
			String Saddress = JTSaddress.getText().trim();
			String Sdept = JTSdept.getText().trim();
			String Dno = JTDno.getText().trim();
			String Sschool = JTSschool.getText().trim();
			String Scheckin = JTScheckin.getText().trim();
			String Smphone = JTSmphone.getText().trim();
			String Ssex = "女";// 返回单选按钮的值
			if (JRb1.isSelected())
				Ssex = "男";

			sql = "select Sno from student where Sno='" + Sno + "'";
			try // 异常处理
			{
				
				ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs);

				if (rs.next())// 判断结果是否存在
					JOptionPane.showMessageDialog(jp, "该学号已经存在,不能重复添加!");// 通过showMessageDialog()方法打印信息
				else {
					sql = "insert into student (Sno,Sname,Sqq,Sclass,Ssex,Sbirthday,Smailbox,Saddress,Sdept,Scheckin,Smphone,Dno,Sschool)"
							+ "values('"
							+ Sno
							+ "','"
							+ Sname
							+ "','"
							+ Sqq
							+ "','"
							+ Sclass
							+ "','"
							+ Ssex
							+ "','"
							+ Sbirthday
							+ "','"
							+ Smailbox
							+ "','"
							+ Saddress
							+ "','"
							+ Sdept
							+ "','"
							+ Scheckin
							+ "','"
							+ Smphone
							+ "','"
							+ Dno
							+ "','" + Sschool + "')";// 插入一组数据

					int i = DBConnect.dataBaseConnect().executeUpdate(sql); // 对数据库进行更新
					if (i > 0)
						JOptionPane.showMessageDialog(null, "添加成功!");
					else
						JOptionPane.showMessageDialog(null, "删除失败!");
				}
				
				DBConnect.dataBaseConnect().close();
			} catch (Exception ee) {
			}
		}

		if (e.getSource() == JBNext)// 处理"重置"事件
		{

			JTSno.setText(null);// 设置文本的text值为null
			JTSname.setText(null); // 设置文本的text值为null
			JTSclass.setText(null);// 设置文本的text值为null
			JTSbirthday.setText(null);
			JTSmailbox.setText(null);
			JTSaddress.setText(null);
			JTSdept.setText(null);
			JTScheckin.setText(null);
			JTSmphone.setText(null);
			JTSschool.setText(null);
			JTDno.setText(null);
			JTSqq.setText(null);
			BG.clearSelection();

		}
	}
}
