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

	JLabel JL = new JLabel("�� �� ѧ�� �� Ϣ", JLabel.CENTER);// ʹ���ı�����һ����ǩ����

	JLabel JLSno = new JLabel("ѧ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSno = new JTextField(); // ����һ���ı������

	JLabel JLDno = new JLabel("�����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTDno = new JTextField(); // ����һ���ı������

	JLabel JLSname = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSname = new JTextField(); // ����һ���ı������

	JLabel JLSsex = new JLabel("�Ա�:"); // ʹ���ı�����һ����ǩ����
	ButtonGroup BG = new ButtonGroup(); // ����һ��ButtonGroup�������
	JRadioButton JRb1 = new JRadioButton("��");
	JRadioButton JRb2 = new JRadioButton("Ů");

	JLabel JLSbirthday = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSbirthday = new JTextField();

	JLabel JLSqq = new JLabel("QQ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSqq = new JTextField();

	JLabel JLSmailbox = new JLabel("����:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSmailbox = new JTextField();

	JLabel JLSaddress = new JLabel("��ͥסַ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSaddress = new JTextField();

	JLabel JLSdept = new JLabel("רҵ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSdept = new JTextField();

	JLabel JLScheckin = new JLabel("��ѧʱ��:"); // ʹ���ı�����һ����ǩ����
	JTextField JTScheckin = new JTextField();

	JLabel JLSmphone = new JLabel("�ֻ���:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSmphone = new JTextField();

	JLabel JLSschool = new JLabel("ѧԺ:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSschool = new JTextField();

	JLabel JLSclass = new JLabel("�༶:"); // ʹ���ı�����һ����ǩ����
	JTextField JTSclass = new JTextField();

	JButton JBAdd = new JButton("���"); // ������ť����
	JButton JBNext = new JButton("����");


	String sql = ""; // ����һ���ַ���
	

	ImageJPanel jp;
	

	public void setjl(JLabel jl) {

		jl.setForeground(Color.BLUE);
		jl.setFont(new Font("����", Font.BOLD, 15));
	}

	public AddStudent() // ����AddStudent���캯��
	{
		
		
		
		jp = new ImageJPanel("lhr_images/201.jpg");
		jp.setLayout(null); // ���ô��ڲ��ֹ�����
		JL.setBounds(100, 20, 200, 40); // ���ñ�ǩ�ĳ�ʼλ��
		JL.setForeground(Color.red);// ���ñ�ǩ��ǰ��ɫ
		JL.setFont(new java.awt.Font("�����п�", Font.PLAIN, 25));// ���ñ�ǩ������
		jp.add(JL); // ����ǩ��ӵ�����

		JLSno.setBounds(100, 70, 100, 20); // ����ѧ�ű�ǩ�ĳ�ʼλ��
		jp.add(JLSno); // ��ѧ�ű�ǩ��ӵ�����
		JTSno.setBounds(200, 70, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSno); // ���ı�����ӵ�����
		setjl(JLSno);

		JLSname.setBounds(100, 100, 100, 20); // ����������ǩ�ĳ�ʼλ��
		jp.add(JLSname); // ��������ǩ��ӵ�����
		JTSname.setBounds(200, 100, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSname); // ���ı�����ӵ�����
		setjl(JLSname);

		JLSsex.setBounds(100, 130, 100, 20); // �����Ա��ǩ�ĳ�ʼλ��
		jp.add(JLSsex); // ���Ա��ǩ��ӵ�����
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

		JLSbirthday.setBounds(100, 160, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSbirthday); // ���༶��ǩ��ӵ�����
		setjl(JLSbirthday);
		JTSbirthday.setBounds(200, 160, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSbirthday); // ���ı�����ӵ�����

		JLSmphone.setBounds(100, 190, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSmphone); // ���༶��ǩ��ӵ�����
		setjl(JLSmphone);
		JTSmphone.setBounds(200, 190, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSmphone);

		JLSqq.setBounds(100, 220, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSqq); // ���༶��ǩ��ӵ�����
		setjl(JLSqq);
		JTSqq.setBounds(200, 220, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSqq);

		JLSmailbox.setBounds(100, 250, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSmailbox); // ���༶��ǩ��ӵ�����
		setjl(JLSmailbox);
		JTSmailbox.setBounds(200, 250, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSmailbox);

		JLSschool.setBounds(100, 280, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSschool); // ���༶��ǩ��ӵ�����
		setjl(JLSschool);
		JTSschool.setBounds(200, 280, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSschool);

		JLSdept.setBounds(100, 310, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSdept); // ���༶��ǩ��ӵ�����
		setjl(JLSdept);
		JTSdept.setBounds(200, 310, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSdept);

		JLSclass.setBounds(100, 340, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSclass); // ���༶��ǩ��ӵ�����
		setjl(JLSclass);
		JTSclass.setBounds(200, 340, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSclass);

		JLDno.setBounds(100, 370, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLDno); // ���༶��ǩ��ӵ�����
		setjl(JLDno);
		JTDno.setBounds(200, 370, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTDno);

		JLScheckin.setBounds(100, 400, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLScheckin); // ���༶��ǩ��ӵ�����
		setjl(JLScheckin);
		JTScheckin.setBounds(200, 400, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTScheckin);

		JLSaddress.setBounds(100, 430, 100, 20); // ���ð༶��ǩ�ĳ�ʼλ��
		jp.add(JLSaddress); // ���༶��ǩ��ӵ�����
		setjl(JLSaddress);
		JTSaddress.setBounds(200, 430, 100, 20); // �����ı���ĳ�ʼλ��
		jp.add(JTSaddress);

		JBAdd.setBounds(120, 470, 70, 20); // ������Ӱ�ť�ĳ�ʼλ��
		jp.add(JBAdd); // ����Ӱ�ť��ӵ�����
		JBAdd.addActionListener(this); // ����ť��Ӽ�����

		JBNext.setBounds(220, 470, 70, 20); // �������ð�ť�ĳ�ʼλ��
		jp.add(JBNext); // �����ð�ť��ӵ�����
		JBNext.addActionListener(this); // ����ť��Ӽ�����

		jp.setBounds(500, 330, 420, 450); // ���ô��ڳߴ��С
		jp.setVisible(true); // ���ô��ڵĿɼ���
		
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == JBAdd)// ����"���"�¼�
		{
			String Sno = JTSno.getText().trim();// ���ı����а������ı������ַ���snumber
			String Sname = JTSname.getText().trim();// ���ı����а������ı������ַ���sname
			String Sclass = JTSclass.getText().trim();// ���ı����а������ı������ַ���sclass
			String Sqq = JTSqq.getText().trim();
			String Sbirthday = JTSbirthday.getText().trim();
			String Smailbox = JTSmailbox.getText().trim();
			String Saddress = JTSaddress.getText().trim();
			String Sdept = JTSdept.getText().trim();
			String Dno = JTDno.getText().trim();
			String Sschool = JTSschool.getText().trim();
			String Scheckin = JTScheckin.getText().trim();
			String Smphone = JTSmphone.getText().trim();
			String Ssex = "Ů";// ���ص�ѡ��ť��ֵ
			if (JRb1.isSelected())
				Ssex = "��";

			sql = "select Sno from student where Sno='" + Sno + "'";
			try // �쳣����
			{
				
				ResultSet rs = DBConnect.dataBaseConnect().executeQuery(sql);// ȡ�ò�ѯ���
				System.out.println("ȡ�ý��OK��" + rs);

				if (rs.next())// �жϽ���Ƿ����
					JOptionPane.showMessageDialog(jp, "��ѧ���Ѿ�����,�����ظ����!");// ͨ��showMessageDialog()������ӡ��Ϣ
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
							+ "','" + Sschool + "')";// ����һ������

					int i = DBConnect.dataBaseConnect().executeUpdate(sql); // �����ݿ���и���
					if (i > 0)
						JOptionPane.showMessageDialog(null, "��ӳɹ�!");
					else
						JOptionPane.showMessageDialog(null, "ɾ��ʧ��!");
				}
				
				DBConnect.dataBaseConnect().close();
			} catch (Exception ee) {
			}
		}

		if (e.getSource() == JBNext)// ����"����"�¼�
		{

			JTSno.setText(null);// �����ı���textֵΪnull
			JTSname.setText(null); // �����ı���textֵΪnull
			JTSclass.setText(null);// �����ı���textֵΪnull
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
