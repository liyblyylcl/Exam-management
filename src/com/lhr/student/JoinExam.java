package com.lhr.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.lhr.main.SDMSlogin;

import com.lhr.share.BackgroundPicture;
import com.lhr.share.DBConnect;
import com.lhr.share.PlaceCenter;

public class JoinExam extends JFrame {

	JLabel chengxinjl, thistimejl, remainingtimejl;
	JTextArea examContentTextArea, textarea;
	JPanel jp1, jp2, jp3, jp4;
	JButton submitjb, finishjb, beforejb;
	JButton startjb = new JButton("开　始");
	JRadioButton jrb1, jrb2, jrb3, jrb4;
	ButtonGroup bg;
	JTextField jtf1, jtf2;
	String s;
	private int grade;
	static int i;
	CountDown tt2;
	int n = -1;

	/**
	 * ******************构造方法***********************
	 */
	public JoinExam() {

		this.setSize(646, 513);
		this.setLayout(null);

		// 调用方法设置背景图片
		BackgroundPicture.setJFrameBackgroundPicture(this, "lhr_images\\3.jpg");

		// 边框
//		Border border = BorderFactory.createLineBorder(Color.BLUE);
		Border border = new LineBorder(Color.BLUE);

		/**************************** 北部区域 **************************/

		chengxinjl = new JLabel("★诚信考试★");
		chengxinjl.setForeground(Color.RED);
		chengxinjl.setFont(new Font("黑体", Font.BOLD, 20));
		chengxinjl.setBounds(280, 20, 200, 20);
		this.add(chengxinjl);

		/*********************** 左边，文本域,面板 ***********************/
		examContentTextArea = new JTextArea(100, 100);
		examContentTextArea.setFont(new Font("宋体", Font.PLAIN, 15));
		examContentTextArea.setForeground(Color.BLUE);
		examContentTextArea.setEditable(false);
		JScrollPane jsp = new JScrollPane(examContentTextArea);
		jsp.setBounds(15, 50, 400, 350);

		// 设置边框
		jsp.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE), "考试内容",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",
						Font.PLAIN, 15), Color.GREEN));

		jsp.setOpaque(false);
		this.add(jsp);

		/***************************** 右上面板 ***************************/

		jp2 = new JPanel();
		jp2.setBounds(425, 70, 200, 150);
		jp2.setOpaque(false);

		// 设置边框
		jp2.setBorder(BorderFactory.createTitledBorder(border, "时间区",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",
						Font.PLAIN, 15), Color.GREEN));

		thistimejl = new JLabel("本题剩余时间:");
		thistimejl.setForeground(Color.BLUE);

		remainingtimejl = new JLabel("本次考试剩余时间:");
		remainingtimejl.setForeground(Color.BLUE);

		jtf1 = new JTextField(15);
		jtf1.setFont(new Font("宋体", Font.BOLD, 15));
		jtf1.setForeground(Color.YELLOW);
		jtf1.setHorizontalAlignment(JTextField.CENTER);// 文本框内容居中显示
		jtf1.setOpaque(false);
		jtf1.setEditable(false);

		jtf2 = new JTextField(15);
		jtf2.setFont(new Font("宋体", Font.BOLD, 15));
		jtf2.setForeground(Color.YELLOW);
		jtf2.setHorizontalAlignment(JTextField.CENTER);// 内容居中显示
		jtf2.setOpaque(false);
		jtf2.setEditable(false);

		jp2.add(thistimejl);
		jp2.add(jtf1);
		jp2.add(remainingtimejl);
		jp2.add(jtf2);

		/******************************* 右下面板 ************************************/

		jp3 = new JPanel();

		jp3.setOpaque(false);
		jp3.setBounds(425, 240, 200, 150);
		jp3.setBorder(BorderFactory.createTitledBorder(border, "答题区",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体",
						Font.PLAIN, 15), Color.GREEN));

		jrb1 = new JRadioButton("A");
		jrb1.setOpaque(false);

		jrb2 = new JRadioButton("B");
		jrb2.setOpaque(false);

		jrb3 = new JRadioButton("C");
		jrb3.setOpaque(false);

		jrb4 = new JRadioButton("D");
		jrb4.setOpaque(false);

		bg = new ButtonGroup();

		// ***************************提交按钮********************************
		submitjb = new JButton("提交本题");
		submitjb.setContentAreaFilled(false);// 设置按钮透明
		submitjb.setForeground(Color.BLUE);
		submitjb.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));
		submitjb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (jrb1.isSelected()) {
					try {
						confirm(jrb1.getText(), i);// 调用方法来计算成绩
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else if (jrb2.isSelected()) {
					try {
						confirm(jrb2.getText(), i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (jrb3.isSelected()) {
					try {
						confirm(jrb3.getText(), i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (jrb4.isSelected()) {
					try {
						confirm(jrb4.getText(), i);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(JoinExam.this,
							"请选择一个选项,谢谢配合！");
				}
				bg.clearSelection();// 取消单选按钮的选择状态

			}

		});

		// *************************开始按钮**********************************

		startjb.setContentAreaFilled(false);// 设置按钮透明
		startjb.setForeground(Color.BLUE);
		startjb.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));
		startjb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				i++;
				if (i == 1) {
					tt2 = new CountDown(jtf1, 300);
					tt2.start();
					startjb.setText("下一题");
					CountDown tt1 = new CountDown(jtf2, 1800);// 创建线程类
					tt1.start();// 启动线程
				}
				if (i >= 2) {
					tt2.flag = false;
					tt2 = new CountDown(jtf1, 300);
					tt2.start();
				}
				examContentTextArea.setText(null);

				try {
					BufferedReader br = new BufferedReader(new FileReader(
							"Informations\\" + i + ".txt"));
					String s = br.readLine();
					while (s != null) {
						examContentTextArea.append(s + "\n");
						s = br.readLine();
					}
					examContentTextArea.append(br.readLine());
				} catch (FileNotFoundException e0) {

					JOptionPane.showMessageDialog(null, "没有题了");
					e0.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				startjb.setEnabled(false);

			}

		});

		// *********************************完成考试按钮*******************************
		finishjb = new JButton("完成考试");
		finishjb.setContentAreaFilled(false);// 设置按钮透明
		finishjb.setForeground(Color.BLUE);
		finishjb.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));
		finishjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				examContentTextArea.setText(null);
				try {
					LinkDataBase();// 显示成绩
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "请退出重新登录,谢谢！");
					e.printStackTrace();
				}

			}
		});

		// *****************************返回按钮***************************************
		beforejb = new JButton("返　回");
		beforejb.setContentAreaFilled(false);// 设置按钮透明
		beforejb.setForeground(Color.BLUE);
		beforejb.setFont(new Font("楷体", Font.CENTER_BASELINE, 15));
		beforejb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					new Student();
					JoinExam.this.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		// **************************添加组件************************************
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		bg.add(jrb4);

		jp3.add(jrb1);
		jp3.add(jrb2);
		jp3.add(jrb3);
		jp3.add(jrb4);
		jp3.add(submitjb);
		jp3.add(startjb);
		jp3.add(finishjb);
		jp3.add(beforejb);

		/************************************ 整体 *************************/

		this.add(jp3);
		this.add(jp2);

		// 调用方法显示答题提示
		setTip();

		this.setIconImage(new ImageIcon("lhr_images\\校徽.jpg").getImage()); // 设置标题图标
		this.setTitle("正在考试");
		new PlaceCenter(this);// 调用方法设置窗口居中
		this.setResizable(false);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * ***************************该方法设置答题小提示*********************
	 */

	public void setTip() {

		// 设置文本域
		textarea = new JTextArea();
		textarea.setForeground(Color.black);// 设置文本域字体颜色
		Font font1 = new Font("宋体", Font.PLAIN, 13);
		textarea.setFont(font1);
		textarea.setBounds(15, BackgroundPicture.imgBackground.getIconHeight() - 75,
				BackgroundPicture.imgBackground.getIconWidth(), 100);
		this.add(textarea);

		BufferedReader fis = null;
		String s = null;
		try {

			fis = new BufferedReader(new FileReader("Informations\\tip.txt"));
			s = fis.readLine();

			while (s != null) {
				textarea.append(s + "\n");
				s = fis.readLine();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		textarea.setOpaque(false);
		textarea.setEditable(false); // 控制文本域内容
	}

	public static void main(String[] args) throws IOException {

		new JoinExam();
	}

	/**
	 * **********************连接数据库方法，实现显示成绩功能********************
	 */

	public void LinkDataBase() throws Exception {

		String s = SDMSlogin.jtf.getText();// 获得登录用户名
		String sql = "select * from student  where Sno= '" + s + "'";
		ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// 取得查询结果

		while (rs.next()) {
			examContentTextArea.setText("　学号: ");
			examContentTextArea.append(rs.getString("Sno") + "\n" + "　成绩：");
			examContentTextArea.append(rs.getString("Grade") + "\n" + "　姓名：");
			examContentTextArea.append(rs.getString("Sname") + "\n");
		}
		DBConnect.dataBaseConnect().close();
	}

	/**
	 * ************************* 计算成绩的方法**********************************
	 */
	public void confirm(String s, int i) throws Exception {

		System.out.println(i);

		n = JOptionPane.showConfirmDialog(JoinExam.this, "你确定选择 " + s + " ?");
		if (n == JOptionPane.YES_OPTION) {

			JOptionPane.showMessageDialog(null, "提交成功!");
			startjb.setEnabled(true);// 置下一道题的按钮为可见的

			String sql = "select answer from matching where ID = " + i;
			ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// 取得查询结果

			if (rs.next()) {
				if (rs.getString("answer").equals(s)) {

					grade += 20;
					String sql1 = "update student set Grade = " + grade
							+ "  where Sno = '" + SDMSlogin.jtf.getText() + "'";
					DBConnect.dataBaseConnect().executeUpdate(sql1);// 对数据库进行更新
					System.out.println("成绩更新OK");
				}
			}
			DBConnect.dataBaseConnect().close();
		}
	}

}
