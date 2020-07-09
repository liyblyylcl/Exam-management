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
 * �����������ñ����ʾ��������
 *
 * @author ���
 * @time 2011-8-29 ����12:47:02 
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

	String[] title = { "ѧ��", "����", "רҵ", "�ɼ�" }; // ����
	String[][] rowData; // �������
	JTable table; // ʵ�������

	public QueryGrade() {

		this.setSize(600, 480);
		this.setLayout(null);
		BackgroundPicture.setJFrameBackgroundPicture(this, "lhr_images\\4.jpg");

		tipjp = new JPanel();
		jl = new JLabel("����д��������");
		jl.setFont(new Font("����", Font.BOLD, 15));
		tipjp.add(jl);
		tipjp.setBounds(20, 10, 550, 40);
		tipjp.setOpaque(false);
		this.add(tipjp);

		namelabel = new JLabel("����");
		namelabel.setForeground(Color.BLUE);
		name = new JTextField(8);

		snolabel = new JLabel("ѧ��");
		snolabel.setForeground(Color.BLUE);
		sno = new JTextField(8);

		majorlabel = new JLabel("רҵ");
		majorlabel.setForeground(Color.BLUE);
		major = new JTextField(10);

		commit = new JButton("��ѯ");
		commit.setForeground(Color.BLUE);
		commit.setContentAreaFilled(false);

		fanhui = new JButton("����");
		fanhui.setForeground(Color.BLUE);
		fanhui.setContentAreaFilled(false);

		rowData = new String[20][4]; // �������
		table = new JTable(rowData, title); // ʵ�������
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

		// ���þ��м���Ԫ����ɫ
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, render);

//		table.setEnabled(false);// ��񲻿ɱ༭
		table.setForeground(Color.BLUE);

		JScrollPane jstablePane = new JScrollPane(table);
		jstablePane.setBounds(20, 100, 550, 320);
		jstablePane.setOpaque(false);
		jstablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(jstablePane);

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("����������װ�أ������������ݿ�...");
			con = DriverManager
					.getConnection("jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\���Թ���ϵͳ���ݿ�.mdb");
		} catch (Exception ex) {
			System.out.println("���ݿ�����������");
		}

		// �����������
		this.setTitle("�ɼ���ѯ");
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
			// ֧��ģ����ѯ�����Ҳ�ѯ������ĳ������Ϊ��ʱ�� ��Ϊ����ȡֵ��������

			sname = " LIKE '%" + name.getText().trim() + "%'";
			smajor = " LIKE '%" + major.getText().trim() + "%'";
			snumber = " LIKE '%" + sno.getText().trim() + "%'";

			command = "SELECT * FROM student WHERE Sname" + sname
					+ " AND Sdept" + smajor + "AND Sno " + snumber;
			PreparedStatement ps = con.prepareStatement(command); // ��ȡPreparedStatement����
			ResultSet rs = ps.executeQuery(); // ִ�в�ѯ

			int count = 0;


			//ÿ�β�ѯ�Ա��������
			for (int i = 0; i < table.getColumnCount(); i++) {				
				for (int j = 0; j < table.getRowCount(); j++) {					
					rowData[j][i] ="";					
				}				
			}
			
			
			table.updateUI();//�������
			
			while (rs.next()) { // ������ѯ���

				rowData[count][0] = rs.getString("Sno");
				rowData[count][1] = rs.getString("Sname"); // ��ʼ����������
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
