package com.lhr.teacher;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.lhr.share.DBConnect;
import com.lhr.share.ImageJPanel;

import java.sql.*;


public class DeleteStudent extends JFrame implements ActionListener {

	
		JLabel JL = new JLabel("删除考生", JLabel.CENTER);// 使用文本创建一个标签对象
		JLabel JLNumber = new JLabel("请输入要删除的考生学号:");// 使用文本创建一个标签对象
		JTextField JTNumber = new JTextField();// 创建一个文本框对象

		JButton JBSet = new JButton("查询");// 创建按钮对象
		JButton JBNext = new JButton("重置");
		JButton deletejb = new JButton("删除");

		JTextArea resultarea = new JTextArea(100,100);
		String sql = ""; // 定义一个字符串

		ImageJPanel jp = new ImageJPanel("lhr_images/203.jpg");
		Statement stm = DBConnect.dataBaseConnect();

		public DeleteStudent() // 创建SetGrade构造函数
		{

			jp.setLayout(null);// 设置窗口布局管理器
			JL.setForeground(Color.red);// 设置标签的前景色
			JL.setFont(new java.awt.Font("华文行楷", Font.PLAIN, 25));// 设置标签的字体
			JL.setBounds(110, 30, 200, 40);// 设置标签的初始位置
			jp.add(JL);// 将标签添加到容器

			JLNumber.setBounds(80, 80, 200, 20);// 设置学号标签的初始位置
			jp.add(JLNumber);// 将学号标签添加到容器
			JLNumber.setForeground(Color.black);
			JLNumber.setFont(new Font("宋体", Font.PLAIN, 15));
			JTNumber.setBounds(260, 80, 80, 20);// 设置文本框的初始位置
			jp.add(JTNumber);// 将文本框添加到容器

			JBSet.setBounds(65, 120, 70, 20);// //设置查询按钮的初始位置
			jp.add(JBSet);// 将查询按钮添加到容器
			JBSet.addActionListener(this);// 给按钮添加监听器
			JBNext.setBounds(175, 120, 70, 20);// 设置重置按钮的初始位置
			jp.add(JBNext);// 将重置按钮添加到容器
			JBNext.addActionListener(this);// 给按钮添加监听器

			deletejb.setBounds(285, 120, 70, 20);// 设置返回按钮的初始位置
			jp.add(deletejb);// 将返回按钮添加到容器
			deletejb.addActionListener(this);// 给按钮添加监听器

			//滚动面板
			JScrollPane js=new JScrollPane(resultarea);
			jp.add(resultarea);
			
			resultarea.setBounds(60, 180, 300, 300);
			resultarea.setFont(new Font("宋体", Font.PLAIN, 15));
			resultarea.setForeground(Color.blue);
			resultarea.setEditable(false);
			resultarea.setOpaque(false);
			resultarea.setBorder(BorderFactory.createLineBorder(Color.black));

			jp.setBounds(10, 10, 500, 400);// 设置窗口尺寸大小
			jp.setLocation(500, 300);
			jp.setVisible(true);// 设置窗口的可见性
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
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
			if (e.getSource() == deletejb) // 处理"删除"事件
			{

				try // 异常处理
				{
					
					String snumber = JTNumber.getText();

					String sql = " delete from  student where Sno = '" + snumber
					+ "' ";

					int n = JOptionPane.showConfirmDialog(jp, "您要确认删除学号为："
							+ snumber + "  的学生记录吗?");

					if (n == JOptionPane.YES_OPTION) {

						int n1 = stm.executeUpdate(sql);// 对数据库进行更新

						if (n1 > 0) {
							JOptionPane.showMessageDialog(jp, "删除成功!");// 通过showMessageDialog()方法打印信息
							JTNumber.setText(null);// 设置文本的text值为null
							resultarea.setText(null);
						
						}else
							JOptionPane.showMessageDialog(jp, "删除失败!");
					} else {
						if (n == JOptionPane.NO_OPTION)
							JOptionPane.showMessageDialog(jp, "未执行删除!");
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



