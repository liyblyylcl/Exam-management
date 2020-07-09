package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import java.util.*;
import javax.swing.event.*;

import com.lhr.share.DBConnect;
import com.lhr.share.ImageJPanel;

import java.sql.*;

public class Addquestion extends JFrame implements ActionListener {

	JLabel JL = new JLabel("添加考题", JLabel.CENTER);// 使用文本创建一个标签对象

	JLabel idjl = new JLabel("试题ID:"); // 使用文本创建一个标签对象
	JTextField idjtf = new JTextField(); // 创建一个文本框对象

	JLabel answerjl = new JLabel("试题答案:"); // 使用文本创建一个标签对象
	JTextField answerjtf = new JTextField(); // 创建一个文本框对象

	JButton JBAdd = new JButton("添加"); // 创建按钮对象
	JButton JBNext = new JButton("重置");

	JLabel jl = new JLabel("试题内容:");
	JTextArea examContentjta = new JTextArea(10, 10);

	ImageJPanel jp = new ImageJPanel("lhr_images/202.jpg");

	String sql = ""; // 定义一个字符串

	// 设置标签的颜色和字体
	public void setjl(JLabel jl) {

		jl.setForeground(Color.black);
		jl.setFont(new Font("宋体", Font.BOLD, 15));
	}

	public Addquestion() // 创建AddStudent构造函数
	{

		jp.setLayout(null);
		JL.setBounds(100, 30, 200, 40); // 设置标签的初始位置
		jp.add(JL); // 将标签添加到容器

		idjl.setBounds(80, 80, 200, 20); // 设置学号标签的初始位置
		setjl(idjl);
		jp.add(idjl); // 将学号标签添加到容器
		idjtf.setBounds(160, 80, 150, 20); // 设置文本框的初始位置
		jp.add(idjtf); // 将文本框添加到容器

		jl.setBounds(80, 120, 100, 20); // 设置学号标签的初始位置
		setjl(jl);
		jp.add(jl); // 将学号标签添加到容器
		examContentjta.setBounds(160, 120, 150, 200); // 设置文本框的初始位置
		jp.add(examContentjta); // 将文本框添加到容器

		answerjl.setBounds(80, 340, 200, 20); // 设置班级标签的初始位置
		setjl(answerjl);
		jp.add(answerjl); // 将班级标签添加到容器
		answerjtf.setBounds(160, 340, 150, 20); // 设置文本框的初始位置
		jp.add(answerjtf);

		JBAdd.setBounds(110, 380, 70, 20); // 设置添加按钮的初始位置
		jp.add(JBAdd); // 将添加按钮添加到容器
		JBAdd.addActionListener(this); // 给按钮添加监听器

		JBNext.setBounds(210, 380, 70, 20); // 设置重置按钮的初始位置
		jp.add(JBNext); // 将重置按钮添加到容器
		JBNext.addActionListener(this); // 给按钮添加监听器

		JL.setForeground(Color.red);// 设置标签的前景色
		JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体

		jp.setBounds(500, 200, 450, 500); // 设置窗口尺寸大小
		jp.setVisible(true); // 设置窗口的可见性

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// 处理"添加"事件
		{
			String Sno = idjtf.getText().trim();// 将文本框中包含的文本传给字符串snumber

			try // 异常处理
			{

				sql = "select ID from matching where ID =" + Sno;
				ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// 取得查询结果
				System.out.println("取得结果OK！" + rs.hashCode());

				if (rs.next())// 判断结果是否存在
					JOptionPane.showMessageDialog(jp, "该题号已经存在,不能重复添加!");// 通过showMessageDialog()方法打印信息
				else {

					sql = "insert into matching (ID,answer) values('" + Sno
							+ "','" + answerjtf.getText().trim() + "')";
					System.out.println("OK");

					int i = DBConnect.dataBaseConnect().executeUpdate(sql); // 对数据库进行更新
					if (i > 0)
						JOptionPane.showMessageDialog(null, "添加成功!");
					else
						JOptionPane.showMessageDialog(null, "删除失败!");
				}

				DBConnect.dataBaseConnect().close();
			} catch (Exception ee) {
			}

			//生成考卷文件
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						"./Informations/" + idjtf.getText() + ".txt"));
				String s = examContentjta.getText();
				bw.write(s);
				bw.flush();// 将缓冲区中的文件写到文件中

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == JBNext)// 处理"重置"事件
		{

			idjtf.setText(null);// 设置文本的text值为null
			examContentjta.setText(null);
			answerjtf.setText(null);

		}
	}

}
