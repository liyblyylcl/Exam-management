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

	JLabel JL = new JLabel("�޸Ŀ�����Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����
	JLabel JLNumber = new JLabel("������Ҫ�޸ĵĿ���ѧ��:");// ʹ���ı�����һ����ǩ����
	JTextField JTNumber = new JTextField();// ����һ���ı������

	JButton JBSet = new JButton("��ѯ");// ������ť����
	JButton JBNext = new JButton("����");
	JButton jb1 = new JButton("�޸�");

	JTextArea resultarea = new JTextArea(100, 100);
	String sql = ""; // ����һ���ַ���

	ImageJPanel jp = new ImageJPanel("lhr_images/208.jpg");
	Statement stm = DBConnect.dataBaseConnect();

	public ManageStudent() // ����SetGrade���캯��
	{

		jp.setLayout(null);// ���ô��ڲ��ֹ�����
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		JL.setBounds(100, 30, 200, 40);// ���ñ�ǩ�ĳ�ʼλ��
		jp.add(JL);// ����ǩ��ӵ�����

		JLNumber.setBounds(80, 80, 300, 20);// ����ѧ�ű�ǩ�ĳ�ʼλ��
		jp.add(JLNumber);// ��ѧ�ű�ǩ��ӵ�����
		JLNumber.setForeground(Color.GREEN);
		JLNumber.setFont(new Font("����", Font.PLAIN, 15));
		JTNumber.setBounds(260, 80, 80, 20);// �����ı���ĳ�ʼλ��
		jp.add(JTNumber);// ���ı�����ӵ�����

		JBSet.setBounds(65, 120, 70, 20);// //���ò�ѯ��ť�ĳ�ʼλ��
		jp.add(JBSet);// ����ѯ��ť��ӵ�����
		JBSet.addActionListener(this);// ����ť��Ӽ�����
		JBNext.setBounds(175, 120, 70, 20);// �������ð�ť�ĳ�ʼλ��
		jp.add(JBNext);// �����ð�ť��ӵ�����
		JBNext.addActionListener(this);// ����ť��Ӽ�����

		jb1.setBounds(285, 120, 70, 20);// ���÷��ذ�ť�ĳ�ʼλ��
		jp.add(jb1);// �����ذ�ť��ӵ�����
		jb1.addActionListener(this);// ����ť��Ӽ�����

		jp.add(resultarea);
		resultarea.setBounds(60, 180, 300, 300);
		resultarea.setFont(new Font("����", Font.PLAIN, 15));
		resultarea.setForeground(Color.blue);
		resultarea.setEditable(false);
		resultarea.setOpaque(false);
		resultarea.setBorder(BorderFactory.createLineBorder(Color.black));
		jp.add(resultarea);

		jp.setBounds(10, 10, 500, 400);// ���ô��ڳߴ��С
		jp.setLocation(500, 300);
		jp.setVisible(true);// ���ô��ڵĿɼ���

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JBSet) // ����"��ѯ"�¼�
		{
			String snumber = JTNumber.getText();// ���ı����а������ı������ַ���snumber

			sql = "select * from  student  where Sno='" + snumber + "'";// ������Id����snumber��ѧ����������Ϣ

			try // �쳣����
			{
				
				ResultSet rs = stm.executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);
				if (rs.next()) // �жϽ���Ƿ����
				{
					resultarea.setText(" ѧ�ţ�");
					resultarea.append(rs.getString("Sno") + "\n" + " ������");
					resultarea.append(rs.getString("Sname") + "\n" + " �Ա�");
					resultarea.append(rs.getString("Ssex") + "\n" + " ���գ�");
					resultarea.append(rs.getString("Sbirthday") + "\n"
							+ " QQ  �� ");
					resultarea.append(rs.getString("Sqq") + "\n" + " �ֻ��ţ�");
					resultarea.append(rs.getString("Smphone") + "\n" + " ���䣺");
					resultarea.append(rs.getString("Smailbox") + "\n"
							+ " ��ͥסַ��");
					resultarea.append(rs.getString("Saddress") + "\n" + " ѧԺ��");
					resultarea.append(rs.getString("Sschool") + "\n" + " רҵ��");
					resultarea.append(rs.getString("Sdept") + "\n" + " �༶��");
					resultarea.append(rs.getString("Sclass") + "\n" + " ����ţ�");
					resultarea.append(rs.getString("Dno") + "\n" + " ��סʱ�䣺");
					resultarea.append(rs.getString("Scheckin"));

				} else {
					JOptionPane.showMessageDialog(null, "���û�������!");
				}
			} catch (Exception ee) {
			}
		}
		if (e.getSource() == JBNext)// ����"����"�¼�
		{
			JTNumber.setText(null);// �����ı���textֵΪnull
			resultarea.setText(null);
		}
		if (e.getSource() == jb1) {
			new xiugaistudent();

		}
	}

}
