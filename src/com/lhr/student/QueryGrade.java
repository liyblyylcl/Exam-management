package com.lhr.student;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


import com.lhr.share.BackgroundPicture;
import com.lhr.share.PlaceCenter;

/**
 * 
 ****************************************************************************
 * 
 * 功能描述：用表格显示数据内容
 *
 * @author 李华荣
 * @time 2011-8-29 下午12:47:02 
 *
 ****************************************************************************
 */
public class QueryGrade extends JFrame implements ActionListener {

	JPanel jp, tipjp;
	JLabel jl;

	private Connection con = null;
	private String command = null;

	private JLabel namelabel;
	private JTextField name;

	private JLabel snolabel;
	private JTextField sno;

	private JLabel majorlabel;
	private JTextField major;

	private JButton commit;
	private JButton fanhui;

	String[] title = { "学号", "姓名", "专业", "成绩" }; // 列名
	String[][] rowData; // 表格数据
	JTable table; // 实例化表格

	public QueryGrade() {

		this.setSize(600, 480);
		this.setLayout(null);
		BackgroundPicture.setJFrameBackgroundPicture(this, "lhr_images\\4.jpg");

		tipjp = new JPanel();
		jl = new JLabel("请填写下列条件");
		jl.setFont(new Font("宋体", Font.BOLD, 15));
		tipjp.add(jl);
		tipjp.setBounds(20, 10, 550, 40);
		tipjp.setOpaque(false);
		this.add(tipjp);

		namelabel = new JLabel("姓名");
		namelabel.setForeground(Color.BLUE);
		name = new JTextField(8);

		snolabel = new JLabel("学号");
		snolabel.setForeground(Color.BLUE);
		sno = new JTextField(8);

		majorlabel = new JLabel("专业");
		majorlabel.setForeground(Color.BLUE);
		major = new JTextField(10);

		commit = new JButton("查询");
		commit.setForeground(Color.BLUE);
		commit.setContentAreaFilled(false);

		fanhui = new JButton("返回");
		fanhui.setForeground(Color.BLUE);
		fanhui.setContentAreaFilled(false);

		rowData = new String[20][4]; // 表格数据
		table = new JTable(rowData, title); // 实例化表格
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.BLUE);

		Border border = BorderFactory.createLineBorder(Color.lightGray);

		jp = new JPanel();
		jp.setBounds(20, 40, 550, 40);
		jp.setOpaque(false);
		jp.setBorder(border);

		jp.add(snolabel);
		jp.add(sno);

		jp.add(namelabel);
		jp.add(name);

		jp.add(majorlabel);
		jp.add(major);

		jp.add(commit);
		commit.addActionListener(this);

		jp.add(fanhui);
		fanhui.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Student();
					QueryGrade.this.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		this.add(jp);

		// 设置居中及单元格颜色
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, render);

//		table.setEnabled(false);// 表格不可编辑
		table.setForeground(Color.BLUE);

		JScrollPane jstablePane = new JScrollPane(table);
		jstablePane.setBounds(20, 100, 550, 320);
		jstablePane.setOpaque(false);
		jstablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(jstablePane);

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("驱动程序已装载，即将连接数据库...");
			con = DriverManager
					.getConnection("jdbc:odbc:MS Access Database;DBQ=数据库文件\\考试管理系统数据库.mdb");
		} catch (Exception ex) {
			System.out.println("数据库连接有问题");
		}

		// 窗口属性设计
		this.setTitle("成绩查询");
		new PlaceCenter(this);
		this.setResizable(false);
		this.setVisible(true);
//		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent evt) {

		try {

			String snovalue = sno.getText().trim();

			String sname, smajor, snumber;
			// 支持模糊查询，并且查询条件中某项输入为空时， 认为此项取值不受限制

			sname = " LIKE '%" + name.getText().trim() + "%'";
			smajor = " LIKE '%" + major.getText().trim() + "%'";
			snumber = " LIKE '%" + sno.getText().trim() + "%'";

			command = "SELECT * FROM student WHERE Sname" + sname
					+ " AND Sdept" + smajor + "AND Sno " + snumber;
			PreparedStatement ps = con.prepareStatement(command); // 获取PreparedStatement对象
			ResultSet rs = ps.executeQuery(); // 执行查询

			int count = 0;


			//每次查询对表格进行清空
			for (int i = 0; i < table.getColumnCount(); i++) {				
				for (int j = 0; j < table.getRowCount(); j++) {					
					rowData[j][i] ="";					
				}				
			}
			
			
			table.updateUI();//更新组件
			
			while (rs.next()) { // 遍历查询结果

				rowData[count][0] = rs.getString("Sno");
				rowData[count][1] = rs.getString("Sname"); // 初始化数组内容
				rowData[count][2] = rs.getString("Sdept");
				rowData[count][3] = rs.getString("Grade");
				count++;
			}



			

		} catch (Exception ex) {
		}
	}

	public static void main(String[] args) {
		new QueryGrade();
	}
}
