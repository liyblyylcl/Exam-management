package com.lhr.teacher;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lhr.share.DBConnect;
import com.lhr.share.ImageJPanel;

public class FindExamQuestions  implements ActionListener {
	
	

		JLabel JL = new JLabel("查询考题", JLabel.CENTER);// 使用文本创建一个标签对象
		JLabel JLNumber = new JLabel("请输入要查询的考题ID:");// 使用文本创建一个标签对象
		JTextField JTNumber = new JTextField();// 创建一个文本框对象

		JButton JBSet = new JButton("查询");// 创建按钮对象
		JButton JBNext = new JButton("重置");


		JTextArea resultarea = new JTextArea(100, 100);
		String sql = ""; // 定义一个字符串

		ImageJPanel jp = new ImageJPanel("lhr_images/205.jpg");
		Statement stm = DBConnect.dataBaseConnect();

		public FindExamQuestions() // 创建SetGrade构造函数
		{

			jp.setLayout(null);// 设置窗口布局管理器
			JL.setForeground(Color.red);// 设置标签的前景色
			JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
			JL.setBounds(110, 30, 200, 40);// 设置标签的初始位置
			jp.add(JL);// 将标签添加到容器

			JLNumber.setBounds(80, 80, 200, 20);// 设置学号标签的初始位置
			jp.add(JLNumber);// 将学号标签添加到容器
			JLNumber.setForeground(Color.GREEN);
			JLNumber.setFont(new Font("宋体", Font.PLAIN, 15));
			JTNumber.setBounds(260, 80, 80, 20);// 设置文本框的初始位置
			jp.add(JTNumber);// 将文本框添加到容器

			JBSet.setBounds(130, 120, 70, 20);// //设置查询按钮的初始位置
			jp.add(JBSet);// 将查询按钮添加到容器
			JBSet.addActionListener(this);// 给按钮添加监听器
			JBNext.setBounds(240, 120, 70, 20);// 设置重置按钮的初始位置
			jp.add(JBNext);// 将重置按钮添加到容器
			JBNext.addActionListener(this);// 给按钮添加监听器


			// 滚动面板
			JScrollPane js = new JScrollPane(resultarea);
			

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

				sql = "select * from  matching  where ID=" + snumber;// 检索出Id等于snumber的学生的所有信息

				try // 异常处理
				{
					
					ResultSet rs = stm.executeQuery(sql);// 取得查询结果
					System.out.println("取得结果OK！" + rs);
					if (rs.next()) // 判断结果是否存在
					{
						resultarea.setText(" 题号：");
						resultarea.append(rs.getString("ID") + "\n" + " 答案：");
						resultarea.append(rs.getString("answer") + "\n");

					} else {
						JOptionPane.showMessageDialog(null, "此题号不存在!");
					}
				} catch (Exception ee) {
				}
			}
			
			if (e.getSource() == JBNext)// 处理"重置"事件
			{
				JTNumber.setText(null);// 设置文本的text值为null
				resultarea.setText(null);
			}

		}

	}

